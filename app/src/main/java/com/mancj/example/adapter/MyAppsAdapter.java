package com.mancj.example.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mancj.example.Page.InstalledFragment;
import com.mancj.example.Page.LibraryFragment;
import com.mancj.example.Page.UpdatesFragment;

public class MyAppsAdapter extends FragmentStatePagerAdapter{

    int TabsNumber;

    public MyAppsAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        TabsNumber = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                UpdatesFragment updatesFragment = new UpdatesFragment();
                return updatesFragment;
            case 1:
                InstalledFragment installedFragment = new InstalledFragment();
                return installedFragment;
            case 2:
                LibraryFragment libraryFragment = new LibraryFragment();
                return libraryFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TabsNumber;
    }
}
