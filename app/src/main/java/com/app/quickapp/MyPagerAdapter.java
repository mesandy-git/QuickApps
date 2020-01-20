package com.app.quickapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.app.quickapp.Fragments.FragmentOne;
import com.app.quickapp.Fragments.FragmentThree;
import com.app.quickapp.Fragments.FragmentTwo;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private static  int NUM_ITEMS=3;
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            case 2:
                return new FragmentThree();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
