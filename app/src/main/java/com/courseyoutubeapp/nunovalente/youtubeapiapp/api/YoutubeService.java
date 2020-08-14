package com.courseyoutubeapp.nunovalente.youtubeapiapp.api;

import com.courseyoutubeapp.nunovalente.youtubeapiapp.model.ResultModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeService {

    @GET("search")
    Call<ResultModel> recoverVideos(@Query("part") String part,
                                    @Query("order") String order,
                                    @Query("maxResults") String maxResults,
                                    @Query("key") String key,
                                    @Query("channelId") String channelId);
}
