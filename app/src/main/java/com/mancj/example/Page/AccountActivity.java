package com.mancj.example.Page;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mancj.example.R;
import com.mancj.example.adapter.AccountAdapter;

public class AccountActivity extends AppCompatActivity implements PreferencesFragment.OnFragmentInteractionListener, RewardsFragment.OnFragmentInteractionListener, PurchaseHistoryFragment.OnFragmentInteractionListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Toolbar toolbar = findViewById(R.id.toolbar);

        // For the app bar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //For Tab Bar widget
        TabLayout tabLayout = findViewById(R.id.tabLayoutAccount);
        tabLayout.addTab(tabLayout.newTab().setText("PREFERENCES"));
        tabLayout.addTab(tabLayout.newTab().setText("REWARDS"));
        tabLayout.addTab(tabLayout.newTab().setText("PURCHASE HISTORY"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pagerAccount);
        final AccountAdapter adapter = new AccountAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
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
    public void onFragmentInteraction(Uri uri) {

    }
}

