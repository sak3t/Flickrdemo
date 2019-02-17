package com.rc.flickrdemo.pojo;

public class photo {

    private long id;

    private String owner;

    private String server;

    private short farm;

    private String secret;

    private String title;

    private byte ispublic;

    public photo(long id, String owner, String server, short farm, String secret, String title, byte ispublic) {
        this.id = id;
        this.owner = owner;
        this.server = server;
        this.farm = farm;
        this.secret = secret;
        this.title = title;
        this.ispublic = ispublic;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public short getFarm() {
        return farm;
    }

    public void setFarm(short farm) {
        this.farm = farm;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte getIspublic() {
        return ispublic;
    }

    public void setIspublic(byte ispublic) {
        this.ispublic = ispublic;
    }
}
