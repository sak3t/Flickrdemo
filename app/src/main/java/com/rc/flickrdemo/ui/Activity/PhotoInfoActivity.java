package com.rc.flickrdemo.ui.Activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rc.flickrdemo.R;
import com.rc.flickrdemo.api.FlickrClient;
import com.rc.flickrdemo.common.Constants;
import com.rc.flickrdemo.pojo.photoInfo;
import com.rc.flickrdemo.pojo.response;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.rc.flickrdemo.common.Constants.FLICKR_IMG_URL;

public class PhotoInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_info);

        Bundle bundle = getIntent().getExtras();
        long photoId  = Long.parseLong(bundle.getString(Constants.PHOTO_ID));

        final ImageView photoLarge = (ImageView) findViewById(R.id.photoLarge);
        final TextView description = (TextView) findViewById(R.id.descriptionText);
        final TextView ownerName = (TextView) findViewById(R.id.ownerName);

        Call<response> call = FlickrClient.getClient().getPhotoInfo(photoId);

        call.enqueue(new Callback<response>() {
            @Override
            public void onResponse(Call<response> call, Response<response> response) {
                photoInfo photoInfo = response.body().getPhoto();

                Uri photoUri = Uri.parse(String.format(FLICKR_IMG_URL, photoInfo.getFarm(), photoInfo.getServer(), photoInfo.getId(),
                        photoInfo.getSecret(), ""));
                Picasso.get().load(photoUri).into(photoLarge);

                description.setText(photoInfo.getDescription().get_content());
                ownerName.setText("Posted by - " + photoInfo.getOwner().getRealname());
            }

            @Override
            public void onFailure(Call<response> call, Throwable t) {
                Toast.makeText(PhotoInfoActivity.this, "Oh No! Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
