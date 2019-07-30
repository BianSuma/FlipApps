package com.mancj.example.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthData {

    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("data")
    @Expose
    private Auth data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Auth getAuth() {
        return data;
    }

    public void setAuth(Auth data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AuthData{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
