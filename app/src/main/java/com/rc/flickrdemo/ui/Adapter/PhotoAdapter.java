package com.rc.flickrdemo.ui.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rc.flickrdemo.R;
import com.rc.flickrdemo.common.Constants;
import com.rc.flickrdemo.pojo.photo;
import com.rc.flickrdemo.ui.Activity.PhotoInfoActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.rc.flickrdemo.common.Constants.FLICKR_IMG_URL;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoHolder> {

    private List<photo> photoList;

    public PhotoAdapter(List<photo> photoList){
        this.photoList = photoList;
    }

    @NonNull
    @Override
    public PhotoAdapter.PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photo_item, parent, false);
        return new PhotoHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.PhotoHolder holder, int position) {
        photo photo = photoList.get(position);
        holder.titleText.setText(photo.getTitle());
        Uri photoUri = Uri.parse(String.format(FLICKR_IMG_URL, photo.getFarm(), photo.getServer(), photo.getId(), photo.getSecret(), "_m"));
        Picasso.get().load(photoUri).into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public void setItems(List<photo> photoList) {
        this.photoList = photoList;
    }

    public class PhotoHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        private final Context mContext;

        public TextView titleText;
        public ImageView photo;

        public PhotoHolder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            titleText = itemView.findViewById(R.id.photoTitle);
            photo = itemView.findViewById(R.id.thumbnailPhoto);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            photo photo = photoList.get(getAdapterPosition());
            Intent intent = new Intent(mContext, PhotoInfoActivity.class);
            Bundle searchBundle = new Bundle();
            searchBundle.putString(Constants.PHOTO_ID, String.valueOf(photo.getId()));
            intent.putExtras(searchBundle);

            mContext.startActivity(intent);
        }
    }
}
