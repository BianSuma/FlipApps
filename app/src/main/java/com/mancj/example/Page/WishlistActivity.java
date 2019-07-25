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
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import android.widget.ProgressBar;
import android.widget.Toast;

import com.mancj.example.R;
import com.mancj.example.adapter.WishlistAdapter;
import com.mancj.example.dialog.AlertDeleteDialog;
import com.mancj.example.dialog.SingleChoiceDialog;
import com.mancj.example.pojo.Wishlist;
import com.mancj.example.pojo.WishlistData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class WishlistActivity extends AppCompatActivity implements SingleChoiceDialog.SingleChoiceListener, AlertDeleteDialog.AlertDeleteListener {

    WishlistAdapter adapter;
    ListView wishlistListView;
    ProgressBar progressBar;
    List<Wishlist> wishlistList;

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
        showWishlist();
    }

    @Override
    public void onPositiveButtonClicked(final String[] list, final int position) {
        sortWishlist(list, position);
    }

    @Override
    public void onPositiveButtonClicked() {

    }

    @Override
    public void onNegativeButtonClicked() {

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
            case R.id.show_all:
                showWishlist();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void populateListView(List<Wishlist> wishlist) {
        wishlistListView = findViewById(R.id.wishlistListView);
        adapter = new WishlistAdapter(wishlist,this);
        wishlistListView.setAdapter(adapter);
    }

    void openDialog(String title) {
        DialogFragment singleChoiceDialog = new SingleChoiceDialog(title);
        singleChoiceDialog.setCancelable(false);
        singleChoiceDialog.show(getSupportFragmentManager(), "Single Choice Dialog");
    }

    void showWishlist() {
        progressBar.setVisibility(View.VISIBLE);
        MyAPIService myAPIService = RetrofitClientInstance.getRetrofitInstance().create(MyAPIService.class);
        Call<WishlistData> call = myAPIService.getWishlist();
        call.enqueue(new Callback<WishlistData>() {
            @Override
            public void onResponse(Call<WishlistData> call, Response<WishlistData> response) {
                progressBar.setVisibility(View.GONE);
                Log.d("WishlistActivity", "onResponse: Server Response: " + response.toString());
                assert response.body() != null;

                if (response.body() == null) {
                    wishlistList = new ArrayList<Wishlist>();
                    populateListView(wishlistList);
                } else {
                    Log.d("WishlistActivity", "onResponse: received information: " + response.body().toString());
                    wishlistList = response.body().getWishlist();
                    populateListView(wishlistList);
                }
            }

            @Override
            public void onFailure(Call<WishlistData> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(WishlistActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    void deleteWishlist(Wishlist delete) {
        // This is delete method for wishlist
        progressBar.setVisibility(View.VISIBLE);
        Wishlist wishlistDelete = new Wishlist();

        for (Wishlist dataWishlist : wishlistList) {
            if (dataWishlist.getApp_id() == delete.getApp_id()) {
                wishlistDelete = delete;
            } else {

            }
        }

        deleteApiService deleteApiService = RetrofitClientInstance.getRetrofitInstance().create(deleteApiService.class);
        Call<WishlistData> call = deleteApiService.deleteWishlist("flip123", wishlistDelete.getApp_id());
        call.enqueue(new Callback<WishlistData>() {
            @Override
            public void onResponse(Call<WishlistData> call, Response<WishlistData> response) {

                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    Log.d("WishlistActivity", "onResponse: Server Response: " + response.toString());
                    assert response.body() != null;
                    Log.d("WishlistActivity", "onResponse: received information: " + response.body().toString());
                    wishlistList.clear();

//                    for(Wishlist datawishlist : response.body().getWishlist()) {
//                        if (datawishlist.getCategory_name().equalsIgnoreCase(list[position])) {
//                            wishlist.add(datawishlist);
//                        } else {
//
//                        }
//                    }
                    populateListView(wishlistList);
                }
            }

            @Override
            public void onFailure(Call<WishlistData> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(WishlistActivity.this, "There's no internet connection", Toast.LENGTH_LONG).show();
            }
        });
    }

    void sortWishlist(final String[] list, final int position) {
        // This is sort method for wishlist by category
        progressBar.setVisibility(View.VISIBLE);
        MyAPIService myAPIService = RetrofitClientInstance.getRetrofitInstance().create(MyAPIService.class);
        Call<WishlistData> call = myAPIService.getWishlist();
        call.enqueue(new Callback<WishlistData>() {
            @Override
            public void onResponse(Call<WishlistData> call, Response<WishlistData> response) {
                progressBar.setVisibility(View.GONE);
                if (response.body() == null) {
                    wishlistList = new ArrayList<Wishlist>();
                    populateListView(wishlistList);
                } else {
                    progressBar.setVisibility(View.GONE);
                    Log.d("WishlistActivity", "onResponse: Server Response: " + response.toString());
                    assert response.body() != null;
                    Log.d("WishlistActivity", "onResponse: received information: " + response.body().toString());
                    wishlistList.clear();

                    for(Wishlist datawishlist : response.body().getWishlist()) {
                        if (datawishlist.getCategory_name().equalsIgnoreCase(list[position])) {
                            wishlistList.add(datawishlist);
                        } else {

                        }
                    }
                    populateListView(wishlistList);
                }
            }

            @Override
            public void onFailure(Call<WishlistData> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(WishlistActivity.this, "There's no internet connection", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

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

interface deleteApiService {
    @FormUrlEncoded
    @POST("/api/wishlist/delete")
    Call<WishlistData> deleteWishlist(@Field("fliptoken") String fliptoken,
                                      @Field("wishlist_id") int wishlist_id);
}