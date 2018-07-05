package com.example.administrator.my12306;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class orderInquiry_fragment extends Fragment {
    finishFragment finishFragment;
    unifinishedFragment unifinishedFragment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        addInnerFragment();
        return inflater.inflate(R.layout.orderlnquiry_layout,container,false);
    }

    private void addInnerFragment() {
        FragmentTransaction fragmentTransaction=getChildFragmentManager().beginTransaction();
        finishFragment=new finishFragment();
        fragmentTransaction.add(finishFragment,"");
        unifinishedFragment=new unifinishedFragment();
        fragmentTransaction.add(unifinishedFragment,"");
        fragmentTransaction.commit();
    }

}
