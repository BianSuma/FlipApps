package com.mancj.example;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.mancj.example.Page.AccountActivity;
import com.mancj.example.Page.CartFragment;
import com.mancj.example.Page.CategoryFragment;
import com.mancj.example.Page.HomeFragment;
import com.mancj.example.adapter.AccountAdapter;
import com.mancj.example.adapter.FragmentAdapter;
import com.mancj.example.Page.MyAppsActivity;
import com.mancj.example.Page.SettingActivity;
import com.mancj.example.Page.WishlistActivity;
import com.mancj.materialsearchbar.MaterialSearchBar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MaterialSearchBar.OnSearchActionListener,
        HomeFragment.OnFragmentInteractionListener, CategoryFragment.OnFragmentInteractionListener, CartFragment.OnFragmentInteractionListener {
    MaterialSearchBar searchBar;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        searchBar = findViewById(R.id.searchBar);
        searchBar.setOnSearchActionListener(this);
        searchBar.inflateMenu(R.menu.main);
        Log.d("LOG_TAG", getClass().getSimpleName() + ": text " + searchBar.getText());
        searchBar.setCardViewElevation(10);
        searchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("LOG_TAG", getClass().getSimpleName() + " text changed " + searchBar.getText());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });

        //For Tab Bar widget
        TabLayout tabLayout = findViewById(R.id.tabSlider);
        tabLayout.addTab(tabLayout.newTab().setText("HOME"));
        tabLayout.addTab(tabLayout.newTab().setText("CATEGORY"));
        tabLayout.addTab(tabLayout.newTab().setText("KART"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.viewPagerSlider);
        final FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_apps) {
            toMyAppsPage();
        } else if (id == R.id.nav_wishlist) {
            toWishlistPage();
        } else if (id == R.id.nav_account) {
            toAccountPage();
        } else if (id == R.id.nav_setting) {
            toSettingPage();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onSearchStateChanged(boolean enabled) {
    }

    @Override
    public void onSearchConfirmed(CharSequence text) {

    }


    //drawer changed
    @Override
    public void onButtonClicked(int buttonCode) {
        switch (buttonCode) {
            case MaterialSearchBar.BUTTON_NAVIGATION:
                drawer.openDrawer(Gravity.LEFT);
                break;
            case MaterialSearchBar.BUTTON_SPEECH:
                break;
            case MaterialSearchBar.BUTTON_BACK:
                searchBar.disableSearch();
                break;
        }
    }

    public void toMyAppsPage() {
        // This method is used for moving to My Apps Page
        startActivity(new Intent(MainActivity.this, MyAppsActivity.class));
    }

    public void toWishlistPage() {
        // This method is used for moving to Wishlist Page
        startActivity(new Intent(MainActivity.this, WishlistActivity.class));
    }

    public void toAccountPage() {
        // This method is used for moving to Account Page
        startActivity(new Intent(MainActivity.this, AccountActivity.class));
    }

    public void toSettingPage() {
        // This method is used for moving to Setting Page
        startActivity(new Intent(MainActivity.this, SettingActivity.class));
    }

    public void shareReviews() {
        // This method is used for sharing the reviews using bluetooth
    }

    public void sendReviews() {
        // This method is used for sending the reviews
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
