package cn.edu.nsu.a12306_program;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by LD on 2018/8/30.
 */

public class TrainListAdapter extends ArrayAdapter{
    private int resourceId;
    private TextView trainNo,fromCity,toCity,startTime,arriveTime,
            durationTime,busyNum,firstNum,secondNum;

    public TrainListAdapter(@NonNull Context context, int resource, List objects) {
        super(context, resource,objects);
        resourceId=resource;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);

    }

    private void initView() {

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        initView();
        TrainInfo trainInfo=(TrainInfo) getItem(position);//获取车次实例
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        trainNo=(TextView)view.findViewById(R.id.Checi);
        fromCity=(TextView)view.findViewById(R.id.startCity);
        toCity=(TextView)view.findViewById(R.id.endCity);
        startTime=(TextView)view.findViewById(R.id.startTime);
        arriveTime=(TextView)view.findViewById(R.id.endTime);
        busyNum=(TextView)view.findViewById(R.id.busyNum);
        firstNum=(TextView)view.findViewById(R.id.firstNum);
        secondNum=(TextView)view.findViewById(R.id.secondNum);
        durationTime=(TextView)view.findViewById(R.id.timeOnTrain);

        trainNo.setText(trainInfo.getTrainNo());
        fromCity.setText(trainInfo.getFromCity());
        toCity.setText(trainInfo.getToCity());
        startTime.setText(trainInfo.getStartTime());
        arriveTime.setText(trainInfo.getArriveTime());
        durationTime.setText(trainInfo.getDurationTime());
        return view;
    }
}
