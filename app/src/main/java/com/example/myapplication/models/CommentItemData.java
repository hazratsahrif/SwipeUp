package com.example.myapplication.models;

public class CommentItemData {

    int avatar, imgCover;
    String tvFName, tvDay, tvComment;

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getImgCover() {
        return imgCover;
    }

    public void setImgCover(int imgCover) {
        this.imgCover = imgCover;
    }

    public String getTvFName() {
        return tvFName;
    }

    public void setTvFName(String tvFName) {
        this.tvFName = tvFName;
    }

    public String getTvDay() {
        return tvDay;
    }

    public void setTvDay(String tvDay) {
        this.tvDay = tvDay;
    }

    public String getTvComment() {
        return tvComment;
    }

    public void setTvComment(String tvComment) {
        this.tvComment = tvComment;
    }

    public CommentItemData(int avatar, int imgCover, String tvFName, String tvDay, String tvComment) {
        this.avatar = avatar;
        this.imgCover = imgCover;
        this.tvFName = tvFName;
        this.tvDay = tvDay;
        this.tvComment = tvComment;
    }
}
