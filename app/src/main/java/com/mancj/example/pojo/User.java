package com.mancj.example.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User {

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
    @SerializedName("user_password")
    @Expose
    private String user_password;
    @SerializedName("user_active_status")
    @Expose
    private int user_active_status;
    @SerializedName("user_joined")
    @Expose
    private Date user_joined;
    @SerializedName("user_company")
    @Expose
    private String user_company;
    @SerializedName("user_company_address")
    @Expose
    private String user_company_address;
    @SerializedName("user_city")
    @Expose
    private String user_city;
    @SerializedName("user_state")
    @Expose
    private String user_state;
    @SerializedName("user_zip")
    @Expose
    private String user_zip;
    @SerializedName("user_credit")
    @Expose
    private String user_credit;
    @SerializedName("user_spec_1")
    @Expose
    private String user_spec_1;
    @SerializedName("user_spec_2")
    @Expose
    private String user_spec_2;
    @SerializedName("user_spec_3")
    @Expose
    private String user_spec_3;
    @SerializedName("user_about")
    @Expose
    private String user_about;

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

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getUser_active_status() {
        return user_active_status;
    }

    public void setUser_active_status(int user_active_status) {
        this.user_active_status = user_active_status;
    }

    public Date getUser_joined() {
        return user_joined;
    }

    public void setUser_joined(Date user_joined) {
        this.user_joined = user_joined;
    }

    public String getUser_company() {
        return user_company;
    }

    public void setUser_company(String user_company) {
        this.user_company = user_company;
    }

    public String getUser_company_address() {
        return user_company_address;
    }

    public void setUser_company_address(String user_company_address) {
        this.user_company_address = user_company_address;
    }

    public String getUser_city() {
        return user_city;
    }

    public void setUser_city(String user_city) {
        this.user_city = user_city;
    }

    public String getUser_state() {
        return user_state;
    }

    public void setUser_state(String user_state) {
        this.user_state = user_state;
    }

    public String getUser_zip() {
        return user_zip;
    }

    public void setUser_zip(String user_zip) {
        this.user_zip = user_zip;
    }

    public String getUser_credit() {
        return user_credit;
    }

    public void setUser_credit(String user_credit) {
        this.user_credit = user_credit;
    }

    public String getUser_spec_1() {
        return user_spec_1;
    }

    public void setUser_spec_1(String user_spec_1) {
        this.user_spec_1 = user_spec_1;
    }

    public String getUser_spec_2() {
        return user_spec_2;
    }

    public void setUser_spec_2(String user_spec_2) {
        this.user_spec_2 = user_spec_2;
    }

    public String getUser_spec_3() {
        return user_spec_3;
    }

    public void setUser_spec_3(String user_spec_3) {
        this.user_spec_3 = user_spec_3;
    }

    public String getUser_about() {
        return user_about;
    }

    public void setUser_about(String user_about) {
        this.user_about = user_about;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_github='" + user_github + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_avatar='" + user_avatar + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_active_status=" + user_active_status +
                ", user_joined=" + user_joined +
                ", user_company='" + user_company + '\'' +
                ", user_company_address='" + user_company_address + '\'' +
                ", user_city='" + user_city + '\'' +
                ", user_state='" + user_state + '\'' +
                ", user_zip='" + user_zip + '\'' +
                ", user_credit='" + user_credit + '\'' +
                ", user_spec_1='" + user_spec_1 + '\'' +
                ", user_spec_2='" + user_spec_2 + '\'' +
                ", user_spec_3='" + user_spec_3 + '\'' +
                ", user_about='" + user_about + '\'' +
                '}';
    }
}
