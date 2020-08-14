package com.courseyoutubeapp.nunovalente.youtubeapiapp.helper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(YoutubeConfig.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
