package com.example.myapplication.models;

public class AllTabItemTwoData {
    int imgAvatar;
    String tvFirstName, tvLikeVideo;
    boolean isPrevDays;

    public int getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(int imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    public String getTvFirstName() {
        return tvFirstName;
    }

    public void setTvFirstName(String tvFirstName) {
        this.tvFirstName = tvFirstName;
    }

    public String getTvLikeVideo() {
        return tvLikeVideo;
    }

    public void setTvLikeVideo(String tvLikeVideo) {
        this.tvLikeVideo = tvLikeVideo;
    }

    public boolean isPrevDays() {
        return isPrevDays;
    }

    public void setPrevDays(boolean prevDays) {
        isPrevDays = prevDays;
    }

    public AllTabItemTwoData(int imgAvatar, String tvFirstName, String tvLikeVideo, boolean isPrevDays) {
        this.imgAvatar = imgAvatar;
        this.tvFirstName = tvFirstName;
        this.tvLikeVideo = tvLikeVideo;
        this.isPrevDays = isPrevDays;
    }
}
