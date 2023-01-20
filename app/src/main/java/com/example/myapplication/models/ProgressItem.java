package com.example.myapplication.models;

public class ProgressItem {
    String tvProgressTitle, tvProgressPercentage;
    int progressValue;

    public String getTvProgressTitle() {
        return tvProgressTitle;
    }

    public void setTvProgressTitle(String tvProgressTitle) {
        this.tvProgressTitle = tvProgressTitle;
    }

    public String getTvProgressPercentage() {
        return tvProgressPercentage;
    }

    public void setTvProgressPercentage(String tvProgressPercentage) {
        this.tvProgressPercentage = tvProgressPercentage;
    }

    public int getProgressValue() {
        return progressValue;
    }

    public void setProgressValue(int progressValue) {
        this.progressValue = progressValue;
    }

    public ProgressItem(String tvProgressTitle, String tvProgressPercentage, int progressValue) {
        this.tvProgressTitle = tvProgressTitle;
        this.tvProgressPercentage = tvProgressPercentage;
        this.progressValue = progressValue;
    }
}
