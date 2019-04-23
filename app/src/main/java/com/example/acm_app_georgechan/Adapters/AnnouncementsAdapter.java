package com.example.acm_app_georgechan.Adapters;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acm_app_georgechan.Models.Announcement;
import com.example.acm_app_georgechan.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementsAdapter extends RecyclerView.Adapter<AnnouncementsAdapter.AnnouncementsViewHolder> {

    Context mContext;
    List<Announcement> mAnnouncements;

    private static final String TAG = "AnnouncementsAdapter";

    public AnnouncementsAdapter(Context context, List<Announcement> announcements) {
        Log.d(TAG, "yes!!");
        mContext = context;
        mAnnouncements = announcements;
    }

    public void setList(List<Announcement> list) {
        mAnnouncements.addAll(list);
    }

    public void resetList(){
        mAnnouncements.clear();
    }

    @NonNull
    @Override
    public AnnouncementsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.announcement_items, parent, false);
        AnnouncementsViewHolder viewHolder = new AnnouncementsViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnnouncementsViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mAnnouncements.size();
    }

    class AnnouncementsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mAnnouncementImage;
        TextView mAnnouncementTitle;
        TextView mAnnouncementAuthor;
        TextView mAnnouncementDate;
        TextView mAnnouncementBody;

        public AnnouncementsViewHolder(View itemView) {
            super(itemView);

            mAnnouncementImage = (ImageView) itemView.findViewById(R.id.announcement_image);
            mAnnouncementTitle = (TextView) itemView.findViewById(R.id.announcement_title);
            mAnnouncementAuthor = (TextView) itemView.findViewById(R.id.announcement_author);
            mAnnouncementDate = (TextView) itemView.findViewById(R.id.announcement_date);
            mAnnouncementBody = (TextView) itemView.findViewById(R.id.anouncement_body);
        }

        void bind(final int position){
            Log.d(TAG, mAnnouncements.get(position).getImageUrl());
            Picasso.with(mContext).load(mAnnouncements.get(position).getImageUrl()).into(mAnnouncementImage);
            mAnnouncementTitle.setText(mAnnouncements.get(position).getTitle());
            mAnnouncementAuthor.setText(mAnnouncements.get(position).getAuthor());
            mAnnouncementDate.setText(mAnnouncements.get(position).getDate());
            mAnnouncementBody.setText(mAnnouncements.get(position).getBody());
        }

        @Override
        public void onClick(View view) {

        }
    }

}
