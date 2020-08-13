package com.courseyoutubeapp.nunovalente.youtubeapiapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.courseyoutubeapp.nunovalente.youtubeapiapp.R;
import com.courseyoutubeapp.nunovalente.youtubeapiapp.adapter.VideoAdapter;
import com.courseyoutubeapp.nunovalente.youtubeapiapp.model.VideoModel;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private MaterialSearchView searchView;
    private RecyclerView recyclerVideos;
    private VideoAdapter videoAdapter;
    private List<VideoModel> videoModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_view);
        recyclerVideos = findViewById(R.id.recyclerVideos);

        configureToolbar();
        configureRecyclerView();
        recoverVideos();
        setListeners();
    }

    private void recoverVideos() {
        VideoModel video1 = new VideoModel();
        video1.setTitle("Video interesting");
        videoModelList.add(video1);

        VideoModel video2 = new VideoModel();
        video2.setTitle("Video not interesting");
        videoModelList.add(video2);

        VideoModel video3 = new VideoModel();
        video3.setTitle("Video for test");
        videoModelList.add(video3);


    }

    private void configureRecyclerView() {
        videoAdapter = new VideoAdapter(getApplicationContext(), videoModelList);
        recyclerVideos.setAdapter(videoAdapter);
        recyclerVideos.setHasFixedSize(true);
        recyclerVideos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }

    private void setListeners() {
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });
    }

    private void configureToolbar() {
        toolbar = findViewById(R.id.toolbarCustom);
        toolbar.setTitle("Youtube");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);

        MenuItem item = menu.findItem(R.id.menu_search);
        searchView.setMenuItem(item);

        return true;
    }
}