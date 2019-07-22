package com.mancj.example.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.mancj.example.Page.CategoryFragment;
import com.mancj.example.Page.HomeFragment;
import com.mancj.example.Page.CartFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    int TabsNumber;

    public FragmentAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        TabsNumber = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                HomeFragment HomeFragment = new HomeFragment();
                return HomeFragment;
            case 1:
                CategoryFragment CategoryFragment = new CategoryFragment();
                return CategoryFragment;
            case 2:
                CartFragment cartFragment = new CartFragment();
                return cartFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TabsNumber;
    }
}
