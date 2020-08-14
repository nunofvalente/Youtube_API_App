package com.courseyoutubeapp.nunovalente.youtubeapiapp.helper;

import com.courseyoutubeapp.nunovalente.youtubeapiapp.BuildConfig;

public class YoutubeConfig {

    private static final String YOUTUBE_API_KEY = BuildConfig.ApiKey;
    private static String CHANNEL_ID = "UC2fVSthyWxWSjsiEAHPzriQ";
    private static String BASE_URL = "https://www.googleapis.com/youtube/v3/";


    public static String getGoogleAPIKey() {return YOUTUBE_API_KEY;}

    public static String getChannelId() {
        return CHANNEL_ID;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

}
