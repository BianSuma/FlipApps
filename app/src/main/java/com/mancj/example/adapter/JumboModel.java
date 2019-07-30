package com.mancj.example.adapter;

public class JumboModel {

    private  int banner;
    private String backgroudnColor;

    public int getBanner() {
        return banner;
    }

    public void setBanner(int banner) {
        this.banner = banner;
    }

    public String getBackgroudnColor() {
        return backgroudnColor;
    }

    public void setBackgroudnColor(String backgroudnColor) {
        this.backgroudnColor = backgroudnColor;
    }

    public JumboModel(int banner, String backgroudnColor) {
        this.banner = banner;
        this.backgroudnColor = backgroudnColor;
    }
}
