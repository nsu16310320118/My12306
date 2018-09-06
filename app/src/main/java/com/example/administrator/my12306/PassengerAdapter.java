package com.example.administrator.my12306;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PassengerAdapter extends BaseAdapter {
    AddPassengers.Passenger passenger;
    private List<AddPassengers.Passenger>results;
    private List<AddPassengers.Passenger>list;
    private Context context;

    public PassengerAdapter(Context context, List<AddPassengers.Passenger> list, List<AddPassengers.Passenger> results){
        this.context=context;
        this.list=list;
        this.results=results;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        passenger = (AddPassengers.Passenger) getItem(position);
        ViewHolder holder=null;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.passenger_info,null);
            holder=new ViewHolder();
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder) convertView.getTag();
        }
        holder.checkBox=convertView.findViewById(R.id.cb);
        holder.txtName=convertView.findViewById(R.id.name);
        holder.humanType=convertView.findViewById(R.id.HumanType);
        holder.txtId=convertView.findViewById(R.id.Id);

        holder.txtName.setText(passenger.getName());
        holder.humanType.setText(passenger.getHumanType());
        holder.txtId.setText(passenger.getIdNumber());



        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    results.add(passenger);
                }else{
                    results.remove(passenger);
                }
            }
        });
        return convertView;
    }

    class ViewHolder {
        CheckBox checkBox;
        TextView txtName;
        TextView txtId;
        TextView humanType;
    }
}
