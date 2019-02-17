package com.rc.flickrdemo.pojo;

public class response {

    private photos photos;

    private photoInfo photo;

    private String stat;

    public com.rc.flickrdemo.pojo.photos getPhotos() {
        return photos;
    }

    public void setPhotos(com.rc.flickrdemo.pojo.photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public photoInfo getPhoto() {
        return photo;
    }

    public void setPhoto(photoInfo photo) {
        this.photo = photo;
    }
}
