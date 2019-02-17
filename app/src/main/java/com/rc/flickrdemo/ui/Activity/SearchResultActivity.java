package com.rc.flickrdemo.ui.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.rc.flickrdemo.R;
import com.rc.flickrdemo.api.FlickrClient;
import com.rc.flickrdemo.common.Constants;
import com.rc.flickrdemo.pojo.photo;
import com.rc.flickrdemo.pojo.photos;
import com.rc.flickrdemo.pojo.response;
import com.rc.flickrdemo.ui.Adapter.PhotoAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultActivity extends AppCompatActivity {

    List<photo> photoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);


        Bundle bundle = getIntent().getExtras();
        String searchTag  = bundle.getString(Constants.SEARCH_TAG);

        photoList = new ArrayList<photo>();

        final RecyclerView recyclerPhotoView = (RecyclerView) findViewById(R.id.RecyclerPhotoView);
        final PhotoAdapter photoAdapter = new PhotoAdapter(photoList);
        recyclerPhotoView.setAdapter(photoAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(SearchResultActivity.this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerPhotoView.setLayoutManager(manager);

        Call<response> call = FlickrClient.getClient().searchPhotos(searchTag);

        call.enqueue(new Callback<response>() {
            @Override
            public void onResponse(Call<response> call, Response<response> response) {
                photos photos = response.body().getPhotos();
                photoAdapter.setItems(photos.getPhoto());
                photoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<response> call, Throwable t) {
                Toast.makeText(SearchResultActivity.this, "Oh No! Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
