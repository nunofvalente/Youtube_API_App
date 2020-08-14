package com.courseyoutubeapp.nunovalente.youtubeapiapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.courseyoutubeapp.nunovalente.youtubeapiapp.BuildConfig;
import com.courseyoutubeapp.nunovalente.youtubeapiapp.R;
import com.courseyoutubeapp.nunovalente.youtubeapiapp.adapter.VideoAdapter;
import com.courseyoutubeapp.nunovalente.youtubeapiapp.api.YoutubeService;
import com.courseyoutubeapp.nunovalente.youtubeapiapp.helper.RetrofitConfig;
import com.courseyoutubeapp.nunovalente.youtubeapiapp.helper.YoutubeConfig;
import com.courseyoutubeapp.nunovalente.youtubeapiapp.model.Items;
import com.courseyoutubeapp.nunovalente.youtubeapiapp.model.ResultModel;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private MaterialSearchView searchView;
    private RecyclerView recyclerVideos;
    private VideoAdapter videoAdapter;
    private List<Items> videos = new ArrayList<>();
    private ResultModel resultModel;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_view);
        recyclerVideos = findViewById(R.id.recyclerVideos);
        retrofit = RetrofitConfig.getRetrofit();

        configureToolbar();
        recoverVideos();
        setListeners();
    }

    private void recoverVideos() {
        YoutubeService youtubeService = retrofit.create(YoutubeService.class);

        Call<ResultModel> call = youtubeService.recoverVideos("snippet", "date", "20", BuildConfig.ApiKey, YoutubeConfig.getChannelId());

        call.enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                if (response.isSuccessful()) {
                    ResultModel result = response.body();
                    Log.d("Result", "Result: " + result.items.get(0).id.videoId);
                    videos = result.items;
                    configureRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<ResultModel> call, Throwable t) {

            }
        });


    }

    private void configureRecyclerView() {
        videoAdapter = new VideoAdapter(getApplicationContext(), videos);
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