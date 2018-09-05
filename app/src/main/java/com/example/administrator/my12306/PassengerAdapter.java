package com.example.administrator.my12306;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
/**
 * Created by LD on 2018/9/4.
 */

public class PassengerAdapter extends ArrayAdapter{
    private int resourceId;

    public PassengerAdapter(@NonNull Context context, int resource, List<AddPassengers.Passenger> objects) {

        super(context, resource,objects);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        AddPassengers.Passenger passenger = (AddPassengers.Passenger) getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView name=view.findViewById(R.id.name);
        name.setText(passenger.getName());

        TextView IdNumber=view.findViewById(R.id.Id);
        IdNumber.setText(passenger.getIdNumber());

        TextView HumanType=view.findViewById(R.id.HumanType);
        HumanType.setText(passenger.getHumanType());
        return view;
    }
}
