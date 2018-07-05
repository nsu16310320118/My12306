package com.example.administrator.my12306;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class mypagerAdapter extends FragmentPagerAdapter {
private ArrayList<Fragment> fragments;
    public mypagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public mypagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments){
        super(fm);
        this.fragments=fragments;
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
