package com.example.administrator.my12306;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrator.my12306.TrainInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class TrainListAdapter extends ArrayAdapter{
    private int resourceId;
    private List<TrainInfo> NUM;
    private TextView trainNo,fromCity,toCity,startTime,arriveTime,
            durationTime,busyNum,firstNum,secondNum;

    public TrainListAdapter(@NonNull Context context, int resource, List<TrainInfo> objects){
        super(context, resource,objects);
        resourceId=resource;
        NUM = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TrainInfo number=(TrainInfo) getItem(position);//获取车次实例
        TrainInfo trainInfo=(TrainInfo) getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
         trainNo=view.findViewById(R.id.number);
         fromCity=view.findViewById(R.id.startCity);
        toCity=view.findViewById(R.id.endCity);
         startTime=view.findViewById(R.id.startTime);
         arriveTime=view.findViewById(R.id.endTime);
         trainNo.setText(trainInfo.getTrainNo());
         fromCity.setText(trainInfo.getFromCity());
         toCity.setText(trainInfo.getToCity());
         startTime.setText(trainInfo.getStartTime());
        arriveTime.setText(trainInfo.getArriveTime());
        return view;
    }
}
