package com.rc.flickrdemo.pojo;

public class photoInfo {

    private long id;

    private owner owner;

    private description description;

    private String server;

    private short farm;

    private String secret;

    public photoInfo(long id, com.rc.flickrdemo.pojo.owner owner, com.rc.flickrdemo.pojo.description description,
                     String server, short farm, String secret) {
        this.id = id;
        this.owner = owner;
        this.description = description;
        this.server = server;
        this.farm = farm;
        this.secret = secret;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public com.rc.flickrdemo.pojo.owner getOwner() {
        return owner;
    }

    public void setOwner(com.rc.flickrdemo.pojo.owner owner) {
        this.owner = owner;
    }

    public com.rc.flickrdemo.pojo.description getDescription() {
        return description;
    }

    public void setDescription(com.rc.flickrdemo.pojo.description description) {
        this.description = description;
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
}
