package com.mancj.example.Page;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.List;
import java.util.Objects;

import android.widget.ProgressBar;
import android.widget.Toast;

import com.mancj.example.R;
import com.mancj.example.adapter.WishlistAdapter;
import com.mancj.example.dialog.SingleChoiceDialog;
import com.mancj.example.pojo.Wishlist;
import com.mancj.example.pojo.WishlistData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public class WishlistActivity extends AppCompatActivity implements SingleChoiceDialog.SingleChoiceListener {

    WishlistAdapter adapter;
    ListView wishlistListView;
    ProgressBar progressBar;
    List<Wishlist> wishlist;

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
                assert response.body() != null;
                Log.d("WishlistActivity", "onResponse: received information: " + response.body().toString());

                wishlist = response.body().getWishlist();
                populateListView(wishlist);
            }

            @Override
            public void onFailure(Call<WishlistData> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(WishlistActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void populateListView(List<Wishlist> wishlist) {
        wishlistListView = findViewById(R.id.wishlistListView);
        adapter = new WishlistAdapter(wishlist,this);
        wishlistListView.setAdapter(adapter);
    }

    @Override
    public void onPositiveButtonClicked(final String[] list, final int position) {
        progressBar.setVisibility(View.VISIBLE);
        MyAPIService myAPIService = RetrofitClientInstance.getRetrofitInstance().create(MyAPIService.class);
        Call<WishlistData> call = myAPIService.getWishlist();
        call.enqueue(new Callback<WishlistData>() {
            @Override
            public void onResponse(Call<WishlistData> call, Response<WishlistData> response) {
                progressBar.setVisibility(View.GONE);
                Log.d("WishlistActivity", "onResponse: Server Response: " + response.toString());
                assert response.body() != null;
                Log.d("WishlistActivity", "onResponse: received information: " + response.body().toString());

//                wishlist = response.body().getWishlist();
                for(Wishlist datawishlist : response.body().getWishlist()) {
                    if (datawishlist.getCategory_name().equalsIgnoreCase(list[position])) {
                        wishlist.add(datawishlist);
                    } else {

                    }
                }
                populateListView(wishlist);
            }

            @Override
            public void onFailure(Call<WishlistData> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(WishlistActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onNegativeButtonClicked() {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.wishlist_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_menu:
                openDialog("sort_menu");
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openDialog(String title) {
        DialogFragment singleChoiceDialog = new SingleChoiceDialog(title);
        singleChoiceDialog.setCancelable(false);
        singleChoiceDialog.show(getSupportFragmentManager(), "Single Choice Dialog");
    }
}

interface MyAPIService {
    @Headers("Content-type: application/json")
    @GET("/api/wishlist?fliptoken=flip123&user_id=1")
    Call<WishlistData> getWishlist();
}