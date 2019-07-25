package com.mancj.example.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WishlistData {

    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("data")
    @Expose
    private List<Wishlist> wishlist;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Wishlist> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<Wishlist> wishlist) {
        this.wishlist = wishlist;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "status='" + status + '\'' +
                ", wishlist=" + wishlist +
                '}';
    }
}
