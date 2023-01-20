package com.example.myapplication.models;

public class BarChartItem {
    String tvHeader, tvDate;
    int cvProgress;

    public String getTvHeader() {
        return tvHeader;
    }

    public void setTvHeader(String tvHeader) {
        this.tvHeader = tvHeader;
    }

    public String getTvDate() {
        return tvDate;
    }

    public void setTvDate(String tvDate) {
        this.tvDate = tvDate;
    }

    public int getCvProgress() {
        return cvProgress;
    }

    public void setCvProgress(int cvProgress) {
        this.cvProgress = cvProgress;
    }

    public BarChartItem(String tvHeader, String tvDate, int cvProgress) {
        this.tvHeader = tvHeader;
        this.tvDate = tvDate;
        this.cvProgress = cvProgress;
    }
}
