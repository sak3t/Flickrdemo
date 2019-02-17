package com.rc.flickrdemo.api;


import com.rc.flickrdemo.common.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlickrClient {

    public static FlickrApi getClient(){
        Retrofit FlickrFit = new Retrofit.Builder()
                .baseUrl(Constants.FLICKR_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return FlickrFit.create(FlickrApi.class);
    }
}
