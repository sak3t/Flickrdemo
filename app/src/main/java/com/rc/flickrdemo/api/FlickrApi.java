package com.rc.flickrdemo.api;

import com.rc.flickrdemo.common.Constants;
import com.rc.flickrdemo.pojo.response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrApi {


    @GET("/services/rest/?method=flickr.photos.search&api_key="+ Constants.API_KEY + "&format=json&nojsoncallback=1")
    Call<response> searchPhotos(@Query("tags") String tags);

    @GET("/services/rest/?method=flickr.photos.getInfo&api_key="+ Constants.API_KEY + "&format=json&nojsoncallback=1")
    Call<response> getPhotoInfo(@Query("photo_id") long photoId);
}
