package com.example.administrator.my12306;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.HotCity;
import com.zaaach.citypicker.model.LocateState;
import com.zaaach.citypicker.model.LocatedCity;

import java.util.ArrayList;
import java.util.List;

public class BookFragment extends Fragment {
    private TextView from,to,godate,gotime;
    private ImageView change;
    private CheckBox student;
    private Button query;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.book_layout,container,false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==2){
            from.setText(data.getStringExtra("site"));
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        from=getActivity().findViewById(R.id.From);
        from.setOnClickListener(new textViewListener());
        to=getActivity().findViewById(R.id.to);
        to.setOnClickListener(new textViewListener());
        godate=getActivity().findViewById(R.id.GoDate);
        gotime=getActivity().findViewById(R.id.GoTime);
        change=getActivity().findViewById(R.id.change);
        change.setOnClickListener(new textViewListener());
        student=getActivity().findViewById(R.id.student);
        query=getActivity().findViewById(R.id.query);
    }
    private class textViewListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent;
            switch (view.getId()){
                case R.id.From:{
                    List<HotCity> hotCities = new ArrayList<>();
                    hotCities.add(new HotCity("北京", "北京", "101010100"));
                    hotCities.add(new HotCity("上海", "上海", "101020100"));
                    hotCities.add(new HotCity("广州", "广东", "101280101"));
                    hotCities.add(new HotCity("深圳", "广东", "101280601"));
                    hotCities.add(new HotCity("杭州", "浙江", "101210101"));
                    CityPicker.getInstance()
                            .setFragmentManager(getActivity().getSupportFragmentManager())
                            .setLocatedCity(new LocatedCity("青城山", "成都", "101210103"))
  .setHotCities(hotCities)
                            .setOnPickListener(new OnPickListener() {
                                @Override
                                public void onPick(int position, City data) {
                                   from.setText(data.getName());
                                }
                                @Override
                                public void onLocate() {
                                    //开始定位，这里模拟一下定位
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            //定位完成之后更新数据
                                            CityPicker.getInstance()
                                                    .locateComplete(new LocatedCity("青城山", "成都", "101210103"), LocateState.SUCCESS);
                                        }
                                    }, 2000);
                                }
                            })
                            .show();
                    break;
                }
                case R.id.to:{
                    List<HotCity> hotCities = new ArrayList<>();
                    hotCities.add(new HotCity("北京", "北京", "101010100"));
                    hotCities.add(new HotCity("上海", "上海", "101020100"));
                    hotCities.add(new HotCity("广州", "广东", "101280101"));
                    hotCities.add(new HotCity("深圳", "广东", "101280601"));
                    hotCities.add(new HotCity("杭州", "浙江", "101210101"));
                    CityPicker.getInstance()
                            .setFragmentManager(getActivity().getSupportFragmentManager())
                            .setLocatedCity(new LocatedCity("青城山", "成都", "101210103"))
                            .setHotCities(hotCities)
                            .setOnPickListener(new OnPickListener() {
                                @Override
                                public void onPick(int position, City data) {
                                    to.setText(data.getName());
                                }
                                @Override
                                public void onLocate() {
                                    //开始定位，这里模拟一下定位
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            //定位完成之后更新数据
                                            CityPicker.getInstance()
                                                    .locateComplete(new LocatedCity("青城山", "成都", "101210103"), LocateState.SUCCESS);
                                        }
                                    }, 2000);
                                }
                            })
                            .show();
                    break;
                }
                case R.id.GoDate:{
                    break;
                }
                case  R.id.change:{
                    String temp=from.getText().toString();
                    from.setText(to.getText().toString());
                    to.setText(temp);
                }
            }
        }
    }
}
