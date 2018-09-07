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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class PassengerAdapter extends BaseAdapter {

    private ArrayList results;
    private ArrayList list;
    private Context context;

    public PassengerAdapter(Context context, ArrayList list, ArrayList results){
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
        return list.get(position);//得到list的某一项
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        final AddPassengers.Passenger passenger= (AddPassengers.Passenger) getItem(position);
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
                    results.add(passenger.getName());
                }else{
                    results.remove(passenger.getName());
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
