package com.example.administrator.my12306;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.my12306.R;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.HotCity;
import com.zaaach.citypicker.model.LocateState;
import com.zaaach.citypicker.model.LocatedCity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookFragment extends Fragment {
    private TextView from,to,godate,gotime,seat;
    private ImageView change,ontime,goodService,travel,sale;
    private CheckBox student;
    private Button query;
    private String strFrom,strTo;
    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    private boolean flag=true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.book_layout,container,false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==6){
            Calendar calendar=Calendar.getInstance();
            int year=calendar.get(Calendar.YEAR);
            int month=calendar.get(Calendar.MONTH);
            int day=calendar.get(Calendar.DAY_OF_MONTH);
            year=data.getIntExtra("year",year);
            month=data.getIntExtra("month",month)+1;
            day=data.getIntExtra("day",day);
            String date=year+"-"+month+"-"+day;
            godate.setText(date);

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
        Date date=new Date(System.currentTimeMillis());
        godate.setText(sdf.format(date));

        godate.setOnClickListener(new textViewListener());
        gotime=getActivity().findViewById(R.id.GoTime);
        gotime.setOnClickListener(new textViewListener());
        change=getActivity().findViewById(R.id.change);
        change.setOnClickListener(new imageViewListener());
        ontime=getActivity().findViewById(R.id.onTimeImage);
        ontime.setOnClickListener(new imageViewListener());
        goodService=getActivity().findViewById(R.id.goodserviceImage);
        goodService.setOnClickListener(new imageViewListener());
        travel=getActivity().findViewById(R.id.travelImage);
        travel.setOnClickListener(new imageViewListener());
        sale=getActivity().findViewById(R.id.saleImage);
        sale.setOnClickListener(new imageViewListener());
        student=getActivity().findViewById(R.id.student);
        query=getActivity().findViewById(R.id.query);
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent queryIntent=new Intent(getActivity(),order_ticket.class);
                queryIntent.putExtra("fromCity",from.getText().toString());
                queryIntent.putExtra("toCity",to.getText().toString());
                queryIntent.putExtra("goDate",godate.getText().toString());
                queryIntent.putExtra("goTime",gotime.getText().toString());
                startActivity(queryIntent);
            }
        });
        seat=getActivity().findViewById(R.id.seat);
        seat.setOnClickListener(new textViewListener());
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
                                    strFrom=data.getName();
                                    if(TextUtils.equals(strFrom,to.getText().toString())){
                                        Toast.makeText(getActivity(),"出发城市非法，请重新选择",Toast.LENGTH_LONG).show();
                                    }
                                    else {
                                        from.setText(strFrom);
                                    }

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
                                    strTo=data.getName();
                                    if(TextUtils.equals(from.getText().toString(),strTo)){
                                        Toast.makeText(getActivity(),"到达城市非法，请重新选择",Toast.LENGTH_LONG).show();
                                    }
                                    else {
                                        to.setText(strTo);
                                    }
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
                    intent=new Intent(getActivity(),DateActivity.class);
                    startActivityForResult(intent,1);
                    break;
                }
                case R.id.GoTime:{
                    AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                    builder.setTitle("选择时间段");
                    final String[] times={"00:00~24:00","06:00~18:00","07:00~10:00"};
                    builder.setItems(times, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            gotime.setText(times[i]);
                        }
                    });
                    builder.show();
                    break;
                }
                case R.id.seat:{
                    AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                    builder.setTitle("席别");
                    final String[] sats={"不限","商务座","特等座","一等座","二等座"};
                    builder.setItems(sats, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            seat.setText(sats[i]);
                        }
                    });
                    builder.show();
                    break;
                }
            }
        }
    }
    private class imageViewListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent;
            switch (view.getId()){
                case  R.id.change:{
                    if(flag) {
                        change.animate().rotation(180);
                        flag=false;
                    }
                    else{
                        change.animate().rotation(0);
                        flag=true;
                    }
                    String temp=from.getText().toString();
                    from.setText(to.getText().toString());
                    to.setText(temp);
                    break;
                }
                case R.id.onTimeImage:{
                    intent=new Intent(getActivity(),timeCheck.class);
                    startActivity(intent);
                    break;
                }
                case R.id.goodserviceImage:{
                    intent=new Intent(getActivity(),warmprompt.class);
                    startActivity(intent);
                    break;
                }
                case R.id.travelImage:{
                    Toast.makeText(getActivity(),"这里是广告",Toast.LENGTH_LONG).show();
                    break;
                }
                case R.id.saleImage:{
                    intent=new Intent(getActivity(),saleCheck.class);
                    startActivity(intent);
                    break;
                }
            }
        }
    }
}
