package com.mancj.example.api;

import com.mancj.example.pojo.AuthData;
import com.mancj.example.pojo.WishlistData;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class RetrofitClientInstance {

    public static Retrofit retrofit;
    public static final String BASE_URL = "https://amentiferous-grass.000webhostapp.com";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public interface MyAPIService {
        @Headers("Content-type: application/json")
        @GET("/api/wishlist?fliptoken=flip123&user_id=1")
        Call<WishlistData> getWishlist();
    }   

    public interface DeleteWishlistService {
        @FormUrlEncoded
        @POST("/api/wishlist/delete")
        Call<WishlistData> deleteWishlist(@Field("fliptoken") String fliptoken,
                                          @Field("wishlist_id") int wishlist_id);
    }

    public interface GetAuth {
        @FormUrlEncoded
        @POST("api/auth/login")
        Call<AuthData> getAuth(@Field("fliptoken") String fliptoken,
                               @Field("user_email") String user_email,
                               @Field("user_password") String user_password);
    }

}
