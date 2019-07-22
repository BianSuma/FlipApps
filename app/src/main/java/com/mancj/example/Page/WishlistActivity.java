package com.mancj.example.Page;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import android.widget.ProgressBar;
import android.widget.Toast;

import com.mancj.example.R;
import com.mancj.example.adapter.WishlistAdapter;
import com.mancj.example.pojo.Wishlist;
import com.mancj.example.pojo.WishlistData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public class WishlistActivity extends AppCompatActivity {

    WishlistAdapter adapter;
    ListView wishlistListView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);
        Toolbar toolbar = findViewById(R.id.toolbar);
        progressBar = findViewById(R.id.wishlistProgressBar);

        // For the tool bar
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Wishlist");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // For the progress bar
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(View.VISIBLE);

        // For the API
        MyAPIService myAPIService = RetrofitClientInstance.getRetrofitInstance().create(MyAPIService.class);
        Call<WishlistData> call = myAPIService.getWishlist();
        call.enqueue(new Callback<WishlistData>() {
            @Override
            public void onResponse(Call<WishlistData> call, Response<WishlistData> response) {
                progressBar.setVisibility(View.GONE);
                Log.d("WishlistActivity", "onResponse: Server Response: " + response.toString());
                Log.d("WishlistActivity", "onResponse: received information: " + response.body().toString());

                List<Wishlist> wishlist = response.body().getWishlist();
                populateListView(wishlist);
            }

            @Override
            public void onFailure(Call<WishlistData> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(WishlistActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
//        call.enqueue(new Callback<Wishlist>() {
//            @Override
//            public void onResponse(Call<List<Aplikasi>> call, Response<List<Aplikasi>> response) {
//                progressBar.setVisibility(View.GONE);
//                populateListView(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<Aplikasi>> call, Throwable t) {
//                progressBar.setVisibility(View.GONE);
//                Toast.makeText(WishlistActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });

        // For the list view

    }

    private void populateListView(List<Wishlist> wishlist) {
        wishlistListView = findViewById(R.id.wishlistListView);
        adapter = new WishlistAdapter(wishlist,this);
        wishlistListView.setAdapter(adapter);
    }

    static class RetrofitClientInstance {
        private static Retrofit retrofit;
        private static final String BASE_URL = "https://amentiferous-grass.000webhostapp.com";
        static Retrofit getRetrofitInstance() {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }
    }
}

interface MyAPIService {
    @Headers("Content-type: application/json")
    @GET("/api/wishlist?fliptoken=flip123&user_id=1")
    Call<WishlistData> getWishlist();
}