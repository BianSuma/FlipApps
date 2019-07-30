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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import android.widget.ProgressBar;
import android.widget.Toast;

import com.mancj.example.R;
import com.mancj.example.adapter.WishlistAdapter;
import com.mancj.example.api.RetrofitClientInstance;
import com.mancj.example.dialog.AlertDeleteDialog;
import com.mancj.example.dialog.SingleChoiceDialog;
import com.mancj.example.pojo.Wishlist;
import com.mancj.example.pojo.WishlistData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    public void onPositiveButtonClicked(Wishlist wishlistDelete) {
        deleteWishlist(wishlistDelete);
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
        RetrofitClientInstance.MyAPIService myAPIService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitClientInstance.MyAPIService.class);
        Call<WishlistData> call = myAPIService.getWishlist();
        call.enqueue(new Callback<WishlistData>() {
            @Override
            public void onResponse(Call<WishlistData> call, Response<WishlistData> response) {
                progressBar.setVisibility(View.GONE);
                Log.d("WishlistActivity", "onResponse: Server Response: " + response.toString());
                assert response.body() != null;

                if (response.body() == null) {
                    wishlistList = new ArrayList<>();
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

    void deleteWishlist(Wishlist wishlistDelete) {
        // This is delete method for wishlist
        progressBar.setVisibility(View.VISIBLE);

        RetrofitClientInstance.DeleteWishlistService deleteWishlistService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitClientInstance.DeleteWishlistService.class);
        Call<WishlistData> call = deleteWishlistService.deleteWishlist("flip123", wishlistDelete.getWishlist_id());
        call.enqueue(new Callback<WishlistData>() {
            @Override
            public void onResponse(Call<WishlistData> call, Response<WishlistData> response) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(WishlistActivity.this, "Wishlist has been successfully deleted.", Toast.LENGTH_LONG).show();

                wishlistList.clear();
                showWishlist();
            }

            @Override
            public void onFailure(Call<WishlistData> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.d("Wishlist Activity", t.getMessage());
                wishlistList.clear();
                showWishlist();
//                Toast.makeText(WishlistActivity.this, "There's no internet connection", Toast.LENGTH_LONG).show();
            }
        });
    }

    void sortWishlist(final String[] list, final int position) {
        // This is sort method for wishlist by category
        progressBar.setVisibility(View.VISIBLE);
        RetrofitClientInstance.MyAPIService myAPIService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitClientInstance.MyAPIService.class);
        Call<WishlistData> call = myAPIService.getWishlist();
        call.enqueue(new Callback<WishlistData>() {
            @Override
            public void onResponse(Call<WishlistData> call, Response<WishlistData> response) {
                progressBar.setVisibility(View.GONE);
                if (response.body() == null) {
                    wishlistList = new ArrayList<>();
                    populateListView(wishlistList);
                } else {
                    Log.d("WishlistActivity", "onResponse: Server Response: " + response.toString());
                    assert response.body() != null;
                    Log.d("WishlistActivity", "onResponse: received information: " + response.body().toString());
                    wishlistList.clear();

                    for(Wishlist datawishlist : response.body().getWishlist()) {
                        if (datawishlist.getCategory_name().equalsIgnoreCase(list[position])) {
                            wishlistList.add(datawishlist);
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

}
