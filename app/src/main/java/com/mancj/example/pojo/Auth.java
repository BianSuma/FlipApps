package com.mancj.example.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Auth {

    @SerializedName("user_id")
    @Expose
    private int user_id;
    @SerializedName("user_name")
    @Expose
    private String user_name;
    @SerializedName("user_email")
    @Expose
    private String user_email;
    @SerializedName("user_github")
    @Expose
    private String user_github;
    @SerializedName("user_phone")
    @Expose
    private String user_phone;
    @SerializedName("user_avatar")
    @Expose
    private String user_avatar;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_github() {
        return user_github;
    }

    public void setUser_github(String user_github) {
        this.user_github = user_github;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_github='" + user_github + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_avatar='" + user_avatar + '\'' +
                '}';
    }
}
