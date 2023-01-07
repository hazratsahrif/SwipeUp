package com.example.myapplication.models;

public class CommentDataModel {

    String tvUserName, tvDay, tvMessage;
    int ivAvatar;
    boolean isCreator, isExpandable;

    public String getTvUserName() {
        return tvUserName;
    }

    public void setTvUserName(String tvUserName) {
        this.tvUserName = tvUserName;
    }

    public String getTvDay() {
        return tvDay;
    }

    public void setTvDay(String tvDay) {
        this.tvDay = tvDay;
    }

    public String getTvMessage() {
        return tvMessage;
    }

    public void setTvMessage(String tvMessage) {
        this.tvMessage = tvMessage;
    }

    public int getIvAvatar() {
        return ivAvatar;
    }

    public void setIvAvatar(int ivAvatar) {
        this.ivAvatar = ivAvatar;
    }

    public boolean isCreator() {
        return isCreator;
    }

    public void setCreator(boolean creator) {
        isCreator = creator;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }

    public CommentDataModel(String tvUserName, String tvDay, String tvMessage, int ivAvatar, boolean isCreator, boolean isExpandable) {
        this.tvUserName = tvUserName;
        this.tvDay = tvDay;
        this.tvMessage = tvMessage;
        this.ivAvatar = ivAvatar;
        this.isCreator = isCreator;
        this.isExpandable = isExpandable;
    }
}
