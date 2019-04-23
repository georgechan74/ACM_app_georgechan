package com.example.acm_app_georgechan.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acm_app_georgechan.Adapters.AnnouncementsAdapter;
import com.example.acm_app_georgechan.Models.Announcement;
import com.example.acm_app_georgechan.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Announcements extends Fragment {

//    private OnFragmentInteractionListener mListener;

    private AnnouncementsAdapter mAdapter;
    private List<Announcement> mAnnouncements = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private static final String TAG = "Announcements";

    public Announcements() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Announcements");
//        return inflater.inflate(R.layout.fragment_announcements, container, false);

        Log.d(TAG, "started announcements");

        View rootView = inflater.inflate(R.layout.fragment_announcements, container, false);

        mRecyclerView = rootView.findViewById(R.id.announcements_rv);
        mAdapter = new AnnouncementsAdapter(container.getContext(), mAnnouncements);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));

        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("Announcements");

        Log.d(TAG, "doen with database");

        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Announcement> announcements = new ArrayList<>();
                resetRecyclerView();

                Log.d(TAG, "before rv");

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Announcement theAnnouncement = new Announcement(
                            (String) ds.child("title").getValue(),
                            (String) ds.child("author").getValue(),
                            (String) ds.child("body").getValue(),
                            (String) ds.child("date").getValue(),
                            (String) ds.child("imageUrl").getValue()
                    );
                    announcements.add(theAnnouncement);
                }

                mAnnouncements = announcements;

                populateRecyclerView(mAnnouncements);

                Log.d(TAG, "after rv");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Log.d(TAG, "done with all");

        return rootView;
    }

    public void populateRecyclerView(List<Announcement> announcements) {
//        mAdapter.mAnnouncements.addAll(announcements);
        mAdapter.setList(announcements);
        mAdapter.notifyDataSetChanged();
    }

    public void resetRecyclerView() {
//        mAdapter.mAnnouncements.clear();
        mAdapter.resetList();
        mAdapter.notifyDataSetChanged();
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
