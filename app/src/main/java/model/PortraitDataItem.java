package model;

public class PortraitDataItem {
    int image;
    String tvTitle;
    boolean isClick;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTvTitle() {
        return tvTitle;
    }

    public void setTvTitle(String tvTitle) {
        this.tvTitle = tvTitle;
    }

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }

    public PortraitDataItem(int image, String tvTitle, boolean isClick) {
        this.image = image;
        this.tvTitle = tvTitle;
        this.isClick = isClick;
    }
}
