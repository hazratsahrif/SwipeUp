package com.example.myapplication.models;

public class LiveMessageItem {
    String tvName, tvMessage;

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

    public LiveMessageItem(String tvName, String tvMessage) {
        this.tvName = tvName;
        this.tvMessage = tvMessage;
    }
}
