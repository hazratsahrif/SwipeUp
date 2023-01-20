package com.example.myapplication.models;

public class SettingItems {
    int icon;
    String tittle;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public SettingItems(int icon, String tittle) {
        this.icon = icon;
        this.tittle = tittle;
    }
}
