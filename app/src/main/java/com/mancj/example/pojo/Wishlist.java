package com.mancj.example.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wishlist {

    @SerializedName("wishlist_id")
    @Expose
    private int wishlist_id;
    @SerializedName("app_id")
    @Expose
    private int app_id;
    @SerializedName("app_name")
    @Expose
    private String app_name;
    @SerializedName("app_price")
    @Expose
    private int app_price;
    @SerializedName("app_poster")
    @Expose
    private String app_poster;
    @SerializedName("category_name")
    @Expose
    private String category_name;

    public int getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(int wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public int getApp_price() {
        return app_price;
    }

    public void setApp_price(int app_price) {
        this.app_price = app_price;
    }

    public String getApp_poster() {
        return app_poster;
    }

    public void setApp_poster(String app_poster) {
        this.app_poster = app_poster;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "WishlistData{" +
                "wishlist_id=" + wishlist_id +
                ", app_id=" + app_id +
                ", app_name='" + app_name + '\'' +
                ", app_price=" + app_price +
                ", app_poster='" + app_poster + '\'' +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
