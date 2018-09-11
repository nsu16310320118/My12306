package com.example.administrator.my12306;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PayTicket extends AppCompatActivity {
    private ListView passengers;
    private Button btnPay, btnIn, btnFan, btnSend, btnCan;
    private TextView fromCity,toCity,goTime,trainNumber;
    private ArrayList list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_ticket);
        Intent payIntent=getIntent();
        fromCity=findViewById(R.id.fromCity_pay);
        fromCity.setText(payIntent.getStringExtra("fromCity"));
        toCity=findViewById(R.id.toCity_pay);
        toCity.setText(payIntent.getStringExtra("toCity"));
        goTime=findViewById(R.id.fromTime_pay);
        goTime.setText(payIntent.getStringExtra("goDate"));
        passengers=findViewById(R.id.passenger_pay);
        list=payIntent.getStringArrayListExtra("result");
        ArrayAdapter adapter=new ArrayAdapter(PayTicket.this,android.R.layout.simple_list_item_1,list);
        passengers.setAdapter(adapter);
        trainNumber=findViewById(R.id.trainNumber_pay);
        trainNumber.setText(payIntent.getStringExtra("trainNumber"));
        btnPay = findViewById(R.id.btnPay);
        btnIn = findViewById(R.id.btnIn);
        btnFan =  findViewById(R.id.btnFan);
        btnSend = findViewById(R.id.btnSend);
        btnCan = findViewById(R.id.btnCan);

        btnPay.setOnClickListener(new btnListener());
        btnIn.setOnClickListener(new btnListener());
        btnFan.setOnClickListener(new btnListener());
        btnSend.setOnClickListener(new btnListener());
        btnCan.setOnClickListener(new btnListener());

        AlertDialog.Builder builder = new AlertDialog.Builder(PayTicket.this);
        builder.setTitle("温馨提示");
        builder.setMessage("购买乘意险 旅行更安心 3元保费最高33万元保障").
                setPositiveButton("购买乘意险", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setNegativeButton("不购", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).show();

    }

    private class btnListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnPay:
                    AlertDialog.Builder builder = new AlertDialog.Builder(PayTicket.this);
                    builder.setMessage("成功支付");
                    builder.show();
                    break;
                case R.id.btnIn:

                    break;
                case R.id.btnFan:
                    //调回book
                    break;
                case R.id.btnSend:
                    AlertDialog.Builder sbuilder = new AlertDialog.Builder(PayTicket.this);
                    sbuilder.setMessage("可以刷票");
                    sbuilder.show();
                    break;
                case R.id.btnCan:
                    AlertDialog.Builder cbuilder = new AlertDialog.Builder(PayTicket.this);
                    cbuilder.setTitle("温馨提示");
                    cbuilder.setMessage("一天之内3次申请车票成功后取消订单，当日将不能在12306继续购票").
                            setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).show();
                    break;
            }
        }
    }
}
