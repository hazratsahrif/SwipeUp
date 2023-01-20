package com.example.myapplication.models;

public class EffcetDataItem {
    int ivCard;
    String tvEffect, tcSubEffect, tvViews;

    public int getIvCard() {
        return ivCard;
    }

    public void setIvCard(int ivCard) {
        this.ivCard = ivCard;
    }

    public String getTvEffect() {
        return tvEffect;
    }

    public void setTvEffect(String tvEffect) {
        this.tvEffect = tvEffect;
    }

    public String getTcSubEffect() {
        return tcSubEffect;
    }

    public void setTcSubEffect(String tcSubEffect) {
        this.tcSubEffect = tcSubEffect;
    }

    public String getTvViews() {
        return tvViews;
    }

    public void setTvViews(String tvViews) {
        this.tvViews = tvViews;
    }

    public EffcetDataItem(int ivCard, String tvEffect, String tcSubEffect, String tvViews) {
        this.ivCard = ivCard;
        this.tvEffect = tvEffect;
        this.tcSubEffect = tcSubEffect;
        this.tvViews = tvViews;
    }
}