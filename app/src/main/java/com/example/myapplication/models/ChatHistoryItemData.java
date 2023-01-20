package com.example.myapplication.models;

public class ChatHistoryItemData {
    int avatar;
    String tvName,tvMessage, tvTime, tvMessageCount;
    boolean isStatus, isLive, isVerified;

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getTvMessage() {
        return tvMessage;
    }

    public void setTvMessage(String tvMessage) {
        this.tvMessage = tvMessage;
    }

    public String getTvTime() {
        return tvTime;
    }

    public void setTvTime(String tvTime) {
        this.tvTime = tvTime;
    }

    public String getTvMessageCount() {
        return tvMessageCount;
    }

    public void setTvMessageCount(String tvMessageCount) {
        this.tvMessageCount = tvMessageCount;
    }

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        isStatus = status;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public ChatHistoryItemData(int avatar, String tvName, String tvMessage, String tvTime, String tvMessageCount, boolean isStatus, boolean isLive, boolean isVerified) {
        this.avatar = avatar;
        this.tvName = tvName;
        this.tvMessage = tvMessage;
        this.tvTime = tvTime;
        this.tvMessageCount = tvMessageCount;
        this.isStatus = isStatus;
        this.isLive = isLive;
        this.isVerified = isVerified;
    }
}
