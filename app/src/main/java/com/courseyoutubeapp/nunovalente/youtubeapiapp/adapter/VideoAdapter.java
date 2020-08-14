package com.courseyoutubeapp.nunovalente.youtubeapiapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.courseyoutubeapp.nunovalente.youtubeapiapp.R;
import com.courseyoutubeapp.nunovalente.youtubeapiapp.model.Items;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyVideoViewHolder> {

    Context context;
    List<Items> videoModelList;

    public VideoAdapter(Context context, List<Items> videoModelList) {
        this.context = context;
        this.videoModelList = videoModelList;
    }

    class MyVideoViewHolder extends RecyclerView.ViewHolder {

        private TextView textTitle;
        private ImageView youTubePlayerView;

        public MyVideoViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.textVideoTitle);
            youTubePlayerView = itemView.findViewById(R.id.youtubePlayerView);
        }
    }

    @NonNull
    @Override
    public MyVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list_adapter, parent, false);

        return new VideoAdapter.MyVideoViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVideoViewHolder holder, int position) {
        Items video = videoModelList.get(position);
        holder.textTitle.setText(video.snippet.title);

        String url = video.snippet.thumbnails.high.url;
        Picasso.get().load(url).into(holder.youTubePlayerView);
    }

    @Override
    public int getItemCount() {
        return videoModelList.size();
    }

}
