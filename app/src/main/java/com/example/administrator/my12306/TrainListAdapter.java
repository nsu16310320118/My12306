package com.example.administrator.my12306;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.administrator.my12306.R;
import java.util.List;

/**
 * Created by LD on 2018/8/30.
 */

public class TrainListAdapter extends ArrayAdapter{
    private int resourceId;
    private List<order_ticket.Number> NUM;

    public TrainListAdapter(@NonNull Context context, int resource, List<order_ticket.Number> objects) {
        super(context, resource,objects);
        resourceId=resource;
        NUM = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        order_ticket.Number number=(order_ticket.Number)getItem(position);//获取车次实例
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView trainNumber=view.findViewById(R.id.number);
        TextView fromCity=view.findViewById(R.id.from_train_number);
        TextView toCity=view.findViewById(R.id.end_train_number);
        trainNumber.setText(NUM.get(position).getNumber());
        fromCity.setText(order_ticket.getFromCity());
        toCity.setText(order_ticket.getToCity());
        return view;
    }
}
