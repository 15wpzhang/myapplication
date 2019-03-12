package com.example.lem.myapplication;

import org.litepal.crud.LitePalSupport;

public class Pro extends LitePalSupport {
    private String name;
    private int imageId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "Pro{" +
                "name='" + name + '\'' +
                ", imageId=" + imageId +
                '}';
    }
}
