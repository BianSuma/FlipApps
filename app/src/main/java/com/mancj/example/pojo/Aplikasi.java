package com.mancj.example.pojo;

import com.google.gson.annotations.SerializedName;

public class Aplikasi {

    @SerializedName("app_id")
    private int app_id;
    @SerializedName("app_name")
    private String app_name;
    @SerializedName("category_name")
    private String category_name;
    @SerializedName("user_name")
    private String user_name;
    @SerializedName("app_desc")
    private String app_desc;
    @SerializedName("app_price")
    private int app_price;
    @SerializedName("app_poster")
    private String app_poster;
    @SerializedName("app_screen_capture_1")
    private String app_screen_capture_1;
    @SerializedName("app_screen_capture_2")
    private String app_screen_capture_2;
    @SerializedName("app_screen_capture_3")
    private String app_screen_capture_3;
    @SerializedName("app_version")
    private String app_version;
    @SerializedName("app_released")
    private String app_released;
    @SerializedName("app_review_value")
    private float app_review_value;
    @SerializedName("app_requirement")
    private String app_requirement;
    @SerializedName("app_demo_link")
    private String app_demo_link;
    @SerializedName("app_last_updated")
    private String app_last_updated;
    @SerializedName("app_purchased")
    private int app_purchased;

    public Aplikasi(int app_id, String app_name, String category_name, String user_name, String app_desc, int app_price, String app_poster, String app_screen_capture_1, String app_screen_capture_2, String app_screen_capture_3, String app_version, String app_released, float app_review_value, String app_requirement, String app_demo_link, String app_last_updated, int app_purchased) {
        this.app_id = app_id;
        this.app_name = app_name;
        this.category_name = category_name;
        this.user_name = user_name;
        this.app_desc = app_desc;
        this.app_price = app_price;
        this.app_poster = app_poster;
        this.app_screen_capture_1 = app_screen_capture_1;
        this.app_screen_capture_2 = app_screen_capture_2;
        this.app_screen_capture_3 = app_screen_capture_3;
        this.app_version = app_version;
        this.app_released = app_released;
        this.app_review_value = app_review_value;
        this.app_requirement = app_requirement;
        this.app_demo_link = app_demo_link;
        this.app_last_updated = app_last_updated;
        this.app_purchased = app_purchased;
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

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getApp_desc() {
        return app_desc;
    }

    public void setApp_desc(String app_desc) {
        this.app_desc = app_desc;
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

    public String getApp_screen_capture_1() {
        return app_screen_capture_1;
    }

    public void setApp_screen_capture_1(String app_screen_capture_1) {
        this.app_screen_capture_1 = app_screen_capture_1;
    }

    public String getApp_screen_capture_2() {
        return app_screen_capture_2;
    }

    public void setApp_screen_capture_2(String app_screen_capture_2) {
        this.app_screen_capture_2 = app_screen_capture_2;
    }

    public String getApp_screen_capture_3() {
        return app_screen_capture_3;
    }

    public void setApp_screen_capture_3(String app_screen_capture_3) {
        this.app_screen_capture_3 = app_screen_capture_3;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }

    public String getApp_released() {
        return app_released;
    }

    public void setApp_released(String app_released) {
        this.app_released = app_released;
    }

    public float getApp_review_value() {
        return app_review_value;
    }

    public void setApp_review_value(float app_review_value) {
        this.app_review_value = app_review_value;
    }

    public String getApp_requirement() {
        return app_requirement;
    }

    public void setApp_requirement(String app_requirement) {
        this.app_requirement = app_requirement;
    }

    public String getApp_demo_link() {
        return app_demo_link;
    }

    public void setApp_demo_link(String app_demo_link) {
        this.app_demo_link = app_demo_link;
    }

    public String getApp_last_updated() {
        return app_last_updated;
    }

    public void setApp_last_updated(String app_last_updated) {
        this.app_last_updated = app_last_updated;
    }

    public int getApp_purchased() {
        return app_purchased;
    }

    public void setApp_purchased(int app_purchased) {
        this.app_purchased = app_purchased;
    }

    @Override
    public String toString() {
        return app_name;
    }
}