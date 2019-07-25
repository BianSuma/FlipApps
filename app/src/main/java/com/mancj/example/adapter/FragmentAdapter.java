package com.mancj.example.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import com.mancj.example.MainActivity;
import com.mancj.example.Page.CategoryFragment;
import com.mancj.example.Page.HomeFragment;
import com.mancj.example.Page.CartFragment;

public class FragmentAdapter extends FragmentStatePagerAdapter {

    int TabsNumber;


    public FragmentAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        TabsNumber = NumberOfTabs;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
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
