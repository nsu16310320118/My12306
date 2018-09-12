package com.example.administrator.my12306;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aurora on 2018/9/11.
 */

public class OrderAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Order> orders;

    public OrderAdapter(Context context, List<Order> orders) {
        inflater = LayoutInflater.from(context);
        this.orders = orders;
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int i) {
        return orders.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.info, viewGroup, false);
            holder = new viewHolder();
            holder.orderInfo =  view.findViewById(R.id.orderInfo);
            holder.orderName = view.findViewById(R.id.orderName);
            holder.orderDate =  view.findViewById(R.id.orderDate);
            holder.orderCity =  view.findViewById(R.id.orderCity);
            holder.goDate = view.findViewById(R.id.goDate);
            view.setTag(holder);
        }else {
            holder= (viewHolder) view.getTag();
        }
        Order order=orders.get(i);
        holder.orderInfo.setText(order.getOrderNo());
        holder.orderName.setText(order.getName());
        holder.orderDate.setText(order.getBuydate());
        holder.orderCity.setText(order.getCity());
        holder.goDate.setText(order.getGodate());

        return view;
    }

    private class viewHolder {
        TextView orderInfo;
        TextView orderName;
        TextView goDate;
        TextView orderCity;
        TextView orderDate;
    }
}
