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
import com.courseyoutubeapp.nunovalente.youtubeapiapp.model.VideoModel;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyVideoViewHolder> {

    Context context;
    List<VideoModel> videoModelList;

    public VideoAdapter(Context context, List<VideoModel> videoModelList) {
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
        VideoModel videoModel = videoModelList.get(position);

        holder.textTitle.setText(videoModel.getTitle());
        holder.youTubePlayerView.setImageResource(R.drawable.padrao);
    }

    @Override
    public int getItemCount() {
        return videoModelList.size();
    }

}
