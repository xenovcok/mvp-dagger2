package com.bmt.zicreative.maidas.main;

/**
 * Created By Herwin DJ on 7/30/2018
 **/

public class MenuItem {
    private int image;
    private String title;

    public MenuItem(int image, String title) {
        this.image = image;
        this.title = title;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
