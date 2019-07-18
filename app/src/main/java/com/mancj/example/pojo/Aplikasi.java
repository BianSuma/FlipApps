package com.mancj.example.pojo;

import com.google.gson.annotations.SerializedName;

public class Aplikasi {

    @SerializedName("app_id")
    private int app_id;
    @SerializedName("app_name")
    private String app_name;
    @SerializedName("app_dev")
    private String app_dev;
    @SerializedName("app_desc")
    private String app_desc;
    @SerializedName("avg_rev")
    private float avg_rev;
    @SerializedName("app_foto")
    private String app_foto;
    @SerializedName("app_harga")
    private int app_harga;
    @SerializedName("category_id")
    private int category_id;
    @SerializedName("app_foto1")
    private String app_foto1;
    @SerializedName("app_foto2")
    private String app_foto2;
    @SerializedName("app_foto3")
    private String app_foto3;

    public Aplikasi(int app_id, String app_name, String app_dev, String app_desc, float avg_rev, String app_foto, int app_harga, int category_id, String app_foto1, String app_foto2, String app_foto3) {
        this.app_id = app_id;
        this.app_name = app_name;
        this.app_dev = app_dev;
        this.app_desc = app_desc;
        this.avg_rev = avg_rev;
        this.app_foto = app_foto;
        this.app_harga = app_harga;
        this.category_id = category_id;
        this.app_foto1 = app_foto1;
        this.app_foto2 = app_foto2;
        this.app_foto3 = app_foto3;
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

    public String getApp_dev() {
        return app_dev;
    }

    public void setApp_dev(String app_dev) {
        this.app_dev = app_dev;
    }

    public String getApp_desc() {
        return app_desc;
    }

    public void setApp_desc(String app_desc) {
        this.app_desc = app_desc;
    }

    public float getAvg_rev() {
        return avg_rev;
    }

    public void setAvg_rev(float avg_rev) {
        this.avg_rev = avg_rev;
    }

    public String getApp_foto() {
        return app_foto;
    }

    public void setApp_foto(String app_foto) {
        this.app_foto = app_foto;
    }

    public int getApp_harga() {
        return app_harga;
    }

    public void setApp_harga(int app_harga) {
        this.app_harga = app_harga;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getApp_foto1() {
        return app_foto1;
    }

    public void setApp_foto1(String app_foto1) {
        this.app_foto1 = app_foto1;
    }

    public String getApp_foto2() {
        return app_foto2;
    }

    public void setApp_foto2(String app_foto2) {
        this.app_foto2 = app_foto2;
    }

    public String getApp_foto3() {
        return app_foto3;
    }

    public void setApp_foto3(String app_foto3) {
        this.app_foto3 = app_foto3;
    }

    @Override
    public String toString() {
        return app_name;
    }
}