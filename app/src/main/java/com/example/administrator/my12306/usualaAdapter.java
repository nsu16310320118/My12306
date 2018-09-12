package com.example.administrator.my12306;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class usualaAdapter extends BaseAdapter {
    private List<Passenger> passengersList;
    private Context context;
    private LayoutInflater inflater;
    public  usualaAdapter(Context context,List<Passenger> passengersList){
        this.context=context;
        this.passengersList=passengersList;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return passengersList.size();
    }

    @Override
    public Object getItem(int i) {
        return passengersList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Passenger passenger = passengersList.get(i);
        ViewHolder viewHolder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.usualadapter, null);
            viewHolder = new ViewHolder();
            viewHolder.name = view.findViewById(R.id.name);
            viewHolder.humanType=view.findViewById(R.id.humanType);
            viewHolder.idNumber=view.findViewById(R.id.idnumber);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.name.setText(passenger.getName());
        viewHolder.humanType.setText(passenger.getHumanType());
        viewHolder.idNumber.setText(passenger.getIdNumber());
        return view;
    }

    static class ViewHolder {
        public TextView name;
        public TextView humanType;
        public TextView idNumber;

    }
}
