package com.rc.flickrdemo.pojo;

import java.util.List;

public class photos {

    private int page;

    private int pages;

    private int perpage;

    private long total;

    private List<photo> photo;

    public photos(int page, int pages, int perpage, long total, List<com.rc.flickrdemo.pojo.photo> photo) {
        this.page = page;
        this.pages = pages;
        this.perpage = perpage;
        this.total = total;
        this.photo = photo;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public void setPerpage(int perpage) {
        this.perpage = perpage;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<com.rc.flickrdemo.pojo.photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<com.rc.flickrdemo.pojo.photo> photo) {
        this.photo = photo;
    }
}
