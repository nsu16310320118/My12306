package com.example.administrator.my12306;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import static com.example.administrator.my12306.R.*;

public class unGo extends AppCompatActivity {
private ticketFragment ticketFragment;
private rideFragment rideFragment;
private ViewPager viewPager;
private mypagerAdapter mypagerAdapter;
private ArrayList<Fragment> fragments;
private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_un_go);
        tabLayout=findViewById(id.ti);
        ticketFragment=new ticketFragment();
        rideFragment=new rideFragment();
        viewPager=findViewById(id.viewPager);
        fragments=new ArrayList<>();
        fragments.add(ticketFragment);
        fragments.add(rideFragment);
        mypagerAdapter=new mypagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(mypagerAdapter);
        viewPager.setCurrentItem(0);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        viewPager.setCurrentItem(0);
                        break;
                    case 1:
                        viewPager.setCurrentItem(1);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}
