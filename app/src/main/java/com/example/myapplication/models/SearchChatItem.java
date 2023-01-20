package com.example.myapplication.models;

public class SearchChatItem {
    int avatar;
    String tvFName,tvLName;

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getTvFName() {
        return tvFName;
    }

    public void setTvFName(String tvFName) {
        this.tvFName = tvFName;
    }

    public String getTvLName() {
        return tvLName;
    }

    public void setTvLName(String tvLName) {
        this.tvLName = tvLName;
    }

    public SearchChatItem(int avatar, String tvFName, String tvLName) {
        this.avatar = avatar;
        this.tvFName = tvFName;
        this.tvLName = tvLName;
    }
}
