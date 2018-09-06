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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ConfirmOrder extends AppCompatActivity {

    private TextView outDate, previous, nextDay, add;
    private TextView fromPort,toport;
    private Button btnCon;
    private ArrayList list;
    private ListView passengers;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

//        outDate = (TextView) findViewById(R.id.tvOutDate);
//        previous = (TextView) findViewById(R.id.tvPrevious);
//        nextDay = (TextView) findViewById(R.id.tvNextDay);
        add = findViewById(R.id.tvAdd);
        btnCon = findViewById(R.id.btnCon);
        fromPort=findViewById(R.id.fromPort);
        toport=findViewById(R.id.toPort);
        list=new ArrayList();
        passengers=findViewById(R.id.passengers);
        Intent intent=getIntent();
        fromPort.setText(intent.getStringExtra("fromCity"));
        toport.setText(intent.getStringExtra("toCity"));

//        outDate.setOnClickListener(new actionListener());
//        previous.setOnClickListener(new actionListener());
//        nextDay.setOnClickListener(new actionListener());
        add.setOnClickListener(new actionListener());
        btnCon.setOnClickListener(new actionListener());

    }

    private class actionListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
//                case R.id.tvOutDate:
//                    Intent intentDate = new Intent(ConfirmOrder.this, DateActivity.class);
//                    startActivityForResult(intentDate, 1);
//                    break;
//                case R.id.tvPrevious:
//                    break;
//                case R.id.tvNextDay:
//
//                    break;
                case R.id.tvAdd:
                    Intent intentPsg = new Intent(ConfirmOrder.this, AddPassengers.class);
                    startActivityForResult(intentPsg,1);
                    break;
                case R.id.btnCon:
                    final AlertDialog.Builder builder = new AlertDialog.Builder(ConfirmOrder.this);
                    builder.setTitle("温馨提示");
                    builder.setMessage("请至少添加一位乘客").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).show();
                    break;
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 0x101:{
                list=data.getStringArrayListExtra("result");
                adapter=new ArrayAdapter(ConfirmOrder.this,android.R.layout.simple_list_item_1,list);
                passengers.setAdapter(adapter);
                break;
            }
        }
    }
}
