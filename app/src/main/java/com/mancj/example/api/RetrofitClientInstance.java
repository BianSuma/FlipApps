package com.mancj.example.api;

import android.content.Context;
import android.widget.Toast;

import com.mancj.example.BuildConfig;
import com.mancj.example.pojo.AuthData;
import com.mancj.example.pojo.WishlistData;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
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
    private static OkHttpClient client;
    public static final String BASE_URL = "https://amentiferous-grass.000webhostapp.com";

    public static Retrofit getRetrofitInstance(final Context context) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }

        if (client == null) {
            client = new OkHttpClient()
                    .newBuilder()
                    .addNetworkInterceptor(interceptor)
                    .addInterceptor(interceptor)
                    .build();
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
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
