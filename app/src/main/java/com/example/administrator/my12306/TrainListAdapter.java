package com.example.administrator.my12306;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.administrator.my12306.R;
import java.util.List;

public class TrainListAdapter extends ArrayAdapter{
    private int resourceId;
    private List<TrainInfo> NUM;

    public TrainListAdapter(@NonNull Context context, int resource, List<TrainInfo> objects) {
        super(context, resource,objects);
        resourceId=resource;
        NUM = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TrainInfo number=(TrainInfo) getItem(position);//获取车次实例
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView trainNumber=view.findViewById(R.id.number);
        TextView fromCity=view.findViewById(R.id.fromCity_number);
        TextView toCity=view.findViewById(R.id.toCity_number);
        TextView startTime=view.findViewById(R.id.startTime);
        TextView endTime=view.findViewById(R.id.endTime);
        trainNumber.setText(NUM.get(position).getTrainNo());
        fromCity.setText(order_ticket.getFromCity());
        toCity.setText(order_ticket.getToCity());
        startTime.setText(NUM.get(position).startTime);
        endTime.setText(NUM.get(position).arriveTime);
        return view;
    }
}
