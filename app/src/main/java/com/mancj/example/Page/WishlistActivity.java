package com.mancj.example.Page;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import java.util.List;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mancj.example.R;
import com.mancj.example.adapter.WishlistAdapter;
import com.mancj.example.pojo.Aplikasi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

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
        getSupportActionBar().setTitle("Wishlist");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // For the progress bar
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(View.VISIBLE);

        // For the API
        MyAPIService myAPIService = RetrofitClientInstance.getRetrofitInstance().create(MyAPIService.class);
        Call<List<Aplikasi>> call = myAPIService.getAplikasi();
        call.enqueue(new Callback<List<Aplikasi>>() {
            @Override
            public void onResponse(Call<List<Aplikasi>> call, Response<List<Aplikasi>> response) {
                progressBar.setVisibility(View.GONE);
                populateListView(response.body());
            }

            @Override
            public void onFailure(Call<List<Aplikasi>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(WishlistActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        // For the list view

    }

    private void populateListView(List<Aplikasi> aplikasiList) {
        wishlistListView = findViewById(R.id.wishlistListView);
        adapter = new WishlistAdapter(aplikasiList, this);
        wishlistListView.setAdapter(adapter);
    }

    static class RetrofitClientInstance {
        private static Retrofit retrofit;
        private static final String BASE_URL = "https://amentiferous-grass.000webhostapp.com";
        public static Retrofit getRetrofitInstance() {
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
    @GET("/api/wishlist?fliptoken=flip123&user_id=1")
    Call<List<Aplikasi>> getAplikasi();
}

