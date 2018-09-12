package com.example.administrator.my12306;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class orderInfo extends AppCompatActivity {

    private ListView lv;
    private List<Order> orders;
    private OrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderinfo);

        lv= (ListView) findViewById(R.id.listInfo);
        initDate();
    }

    private void initDate() {
        orders=new ArrayList<Order>();
        for (int i=0; i<8;i++){
            Order order=new Order("12345678","hdjh","08-22 22:22","A-B","08-02 11:11",1);
            orders.add(order);
        }
        adapter=new OrderAdapter(this,orders);
        lv.setAdapter(adapter);
    }
}
