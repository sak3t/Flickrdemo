package com.rc.flickrdemo.pojo;

public class owner {

    private String nsid;

    private String username;

    private String realname;

    public owner(String nsid, String username, String realname) {
        this.nsid = nsid;
        this.username = username;
        this.realname = realname;
    }

    public String getNsid() {
        return nsid;
    }

    public void setNsid(String nsid) {
        this.nsid = nsid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
}
