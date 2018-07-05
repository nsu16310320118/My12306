package com.example.administrator.my12306;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ViewPager viewPager;
private BookFragment bookFragment;
private service_fragment serviceFragment;
private mypagerAdapter mypagerAdapter;
private orderInquiry_fragment orderInquiryFragment;
private mineFragment mineFragment;
private ArrayList<Fragment> fragments;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {//加载不同的XML文件
                case R.id.navigation_book:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_service:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_orderInquiry:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_my12306:
                    viewPager.setCurrentItem(3);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        viewPager=findViewById(R.id.viewPager);

        fragments=new ArrayList<Fragment>();
        bookFragment=new BookFragment();
        serviceFragment=new service_fragment();
        orderInquiryFragment=new orderInquiry_fragment();
        mineFragment=new mineFragment();
        fragments.add(bookFragment);
        fragments.add(serviceFragment);
        fragments.add(orderInquiryFragment);
        fragments.add(mineFragment);
        mypagerAdapter=new mypagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(mypagerAdapter);
        viewPager.setCurrentItem(0);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
