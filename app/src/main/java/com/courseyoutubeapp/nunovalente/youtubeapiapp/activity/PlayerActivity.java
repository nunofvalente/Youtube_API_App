package com.courseyoutubeapp.nunovalente.youtubeapiapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.courseyoutubeapp.nunovalente.youtubeapiapp.BuildConfig;
import com.courseyoutubeapp.nunovalente.youtubeapiapp.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayerActivity extends YouTubeBaseActivity
                            implements YouTubePlayer.OnInitializedListener {

    private String videoId;

    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        youTubePlayerView = findViewById(R.id.youtubePlayer);

        recoverData();
    }

    private void recoverData() {
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            videoId = bundle.get("videoId").toString();
            youTubePlayerView.initialize(BuildConfig.ApiKey, this);
        }

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        youTubePlayer.setFullscreen(true);
        youTubePlayer.setShowFullscreenButton(false);
        youTubePlayer.loadVideo(videoId);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}