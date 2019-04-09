package com.example.acm_app_georgechan.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acm_app_georgechan.Models.Event;
import com.example.acm_app_georgechan.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ResourceAdapter extends RecyclerView.Adapter<ResourceAdapter.ResourceViewHolder> {
    Context mContext;
    List<Event> mEvents;
    private static final String TAG = "ResourceAdapter";

    public ResourceAdapter(Context context, List<Event> events) {
        mContext = context;
        mEvents = events;
    }

    @NonNull
    @Override
    public ResourceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.resource_items, parent, false);
        ResourceViewHolder viewHolder = new ResourceViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResourceViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    class ResourceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mEventImage;
        TextView mEventName;
        TextView mEventLocation;
        TextView mEventStart;
        TextView mEventEnd;
        TextView mEventHsOnly;

        public ResourceViewHolder(View itemView) {
            super(itemView);
//            Log.d(TAG, "test1");

            mEventImage = (ImageView) itemView.findViewById(R.id.event_img);
            mEventName = (TextView) itemView.findViewById(R.id.event_name);
            mEventLocation = (TextView) itemView.findViewById(R.id.event_location);
            mEventStart = (TextView) itemView.findViewById(R.id.event_start);
            mEventEnd = (TextView) itemView.findViewById(R.id.event_end);
            mEventHsOnly = (TextView) itemView.findViewById(R.id.event_hs_only);
        }

        void bind(final int position) {
//            Log.d(TAG, "test2");
            Picasso.with(mContext).load(mEvents.get(position).getImageUrl()).into(mEventImage);
            mEventName.setText(mEvents.get(position).getName());
            mEventLocation.setText("Located at " + mEvents.get(position).getLocation());
            mEventStart.setText("Starts at " + mEvents.get(position).getStartDate());
            mEventEnd.setText("Ends at " + mEvents.get(position).getEndDate());
            if (mEvents.get(position).isHighSchool())
                mEventHsOnly.setText("High-schoolers only");
            else
                mEventHsOnly.setText("");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String urlString = mEvents.get(getAdapterPosition()).getUrl();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
            mContext.startActivity(browserIntent);
//            Log.d(TAG, "clicked");
//            Toast.makeText(mContext, "test", Toast.LENGTH_LONG);
        }
    }
}
