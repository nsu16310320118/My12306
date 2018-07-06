package com.example.administrator.my12306;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class historyOrder extends AppCompatActivity {
private EditText startTime,endTime,trainNumber,passengerName,orderNumber;
private Button quiry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_order);
        startTime=findViewById(R.id.startTime);
        endTime=findViewById(R.id.endTime);
        trainNumber=findViewById(R.id.train_number);
        passengerName=findViewById(R.id.passengerName);
        orderNumber=findViewById(R.id.orderNumber);
        quiry=findViewById(R.id.query);
        //-----------------------------
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //选择新的起始时间
            }
        });
        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //选择新的结束时间
            }
        });
        quiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //查询历史订单
            }
        });

    }
}
