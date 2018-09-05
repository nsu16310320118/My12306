package com.example.administrator.my12306;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by LD on 2018/9/4.
 */

public class PassengerAdapter extends ArrayAdapter{
    private int resourceId;
    private LayoutInflater inflater=null;
    private int temp=-1;
    ViewHolder holder ;

    public PassengerAdapter(@NonNull Context context, int resource, List<AddPassengers.Passenger> objects) {

        super(context, resource,objects);
        resourceId=resource;
        inflater=LayoutInflater.from(context);
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

        holder=null;
        if (holder==null){
            holder=new ViewHolder();
            convertView=inflater.inflate(R.layout.passenger_info,null);
            holder.cb=convertView.findViewById(R.id.cb);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }

        holder.cb.setId(position);
        holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    if (temp!=-1){
//                        CheckBox tempcb=
                    }
                }
            }
        });

        CheckBox cb=view.findViewById(R.id.cb);



        return view;
    }

    private class ViewHolder{
        public CheckBox cb;
    }
}
