package com.example.myapplication.models;

import java.util.List;

public class LikeModel {
    String tvFirstName, tvLike;
    int coverImage,imgAvatar;
    boolean isLive;

    public String getTvFirstName() {
        return tvFirstName;
    }

    public void setTvFirstName(String tvFirstName) {
        this.tvFirstName = tvFirstName;
    }

    public String getTvLike() {
        return tvLike;
    }

    public void setTvLike(String tvLike) {
        this.tvLike = tvLike;
    }

    public int getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(int coverImage) {
        this.coverImage = coverImage;
    }

    public int getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(int imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public LikeModel(String tvFirstName, String tvLike, int coverImage, int imgAvatar, boolean isLive) {
        this.tvFirstName = tvFirstName;
        this.tvLike = tvLike;
        this.coverImage = coverImage;
        this.imgAvatar = imgAvatar;
        this.isLive = isLive;
    }
}
