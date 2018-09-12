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
    private TextView trainNo,fromCity,toCity,startTime,arriveTime,bestNum,betterNum,goodNum;

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
         bestNum=view.findViewById(R.id.bestNum);
         betterNum=view.findViewById(R.id.betterNum);
         goodNum=view.findViewById(R.id.goodNum);
         trainNo.setText(trainInfo.getTrainNo());
         fromCity.setText(trainInfo.getFromCity());
         toCity.setText(trainInfo.getToCity());
         startTime.setText(trainInfo.getStartTime());
        arriveTime.setText(trainInfo.getArriveTime());
        String best=trainInfo.getMap().get("seatName0")+":"+trainInfo.getMap().get("seatNum0");
        bestNum.setText(best);
        String better=trainInfo.getMap().get("seatName1")+":"+trainInfo.getMap().get("seatNum1");
        betterNum.setText(better);
        String good=trainInfo.getMap().get("seatName2")+":"+trainInfo.getMap().get("seatNum2");
        goodNum.setText(good);
        return view;
    }
}
