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
import java.util.HashMap;
import java.util.List;

public class ConfirmOrder extends AppCompatActivity {

    private TextView bestPrice,betterPrice,goodPrice,wirstPrice,worsePrice,add;
    private TextView fromPort,toport,orderTime,trainNumber,outTime,arriveTime,time_confirm;
    private Button btnCon,btnBest,btnBetter,btnGood,btnWorst;
    private ArrayList list;
    private ListView passengers;
    private ArrayAdapter adapter;
    private TopBarForP topBarForP;
    int size,flag=0;;
    HashMap hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

//        outDate = (TextView) findViewById(R.id.tvOutDate);
//        previous = (TextView) findViewById(R.id.tvPrevious);
//        nextDay = (TextView) findViewById(R.id.tvNextDay);
        topBarForP=findViewById(R.id.topbarforp);
        time_confirm=findViewById(R.id.time_confirm);
        add = findViewById(R.id.tvAdd);
        btnCon = findViewById(R.id.btnCon);
        fromPort=findViewById(R.id.fromPort);
        toport=findViewById(R.id.toPort);
        orderTime=findViewById(R.id.outTime);
        trainNumber=findViewById(R.id.trainNumber_order);
        outTime=findViewById(R.id.outTime);
        arriveTime=findViewById(R.id.arriveTime);
        btnBest=findViewById(R.id.btnBest);
        btnBetter=findViewById(R.id.btnBetter);
        btnGood=findViewById(R.id.btnGood);
        btnWorst=findViewById(R.id.btnWorse);
        list=new ArrayList();
        passengers=findViewById(R.id.passengers);
        topBarForP.setTitleTextView("确认订单");
        topBarForP.setOnLeftAndRightClickListener(new TopBarForP.OnLeftAndRightClickListener() {
            @Override
            public void OnLeftButtonClick() {
                finish();
            }

            @Override
            public void OnRightButtonClick() {
            }
        });
        Intent intent=getIntent();
        fromPort.setText(intent.getStringExtra("fromCity"));
        toport.setText(intent.getStringExtra("toCity"));
        time_confirm.setText(intent.getStringExtra("goDate"));
        trainNumber.setText(intent.getStringExtra("trainNumber"));
        outTime.setText(intent.getStringExtra("goTime"));
        arriveTime.setText(intent.getStringExtra("endTime"));
        Bundle bundle = getIntent().getExtras();
        SerializableHashMap serializableHashMap = (SerializableHashMap) bundle.get("hashMap");
        hashMap=serializableHashMap.getMap();
        size=hashMap.size()/3;
        String best=hashMap.get("seatName0")+"\n"+hashMap.get("seatPrice0");
        btnBest.setText(best);
        String better=hashMap.get("seatName1")+"\n"+hashMap.get("seatPrice1");
        btnBetter.setText(better);
        String good=hashMap.get("seatName2")+"\n"+hashMap.get("seatPrice2");
        btnGood.setText(good);
        if(size>=4){
            String worse=hashMap.get("seatName3")+"\n"+hashMap.get("seatPrice3");
            btnWorst.setText(worse);
        }
        else {
            String str="无座"+"\n"+hashMap.get("seatPrice0");
            btnWorst.setText(str);
        }

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
                    if(list.size()==0){
                    final AlertDialog.Builder builder = new AlertDialog.Builder(ConfirmOrder.this);
                    builder.setTitle("温馨提示");
                    builder.setMessage("请至少添加一位乘客").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).show();}
                    else{
                            Intent payIntent=new Intent(ConfirmOrder.this,PayTicket.class);
                            payIntent.putExtra("fromCity",fromPort.getText());
                            payIntent.putExtra("toCity",toport.getText());
                            payIntent.putExtra("goDate",orderTime.getText());
                            payIntent.putExtra("result",list);
                            payIntent.putExtra("trainNumber",trainNumber.getText());
                            startActivity(payIntent);
                    }
                    break;
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 0x101:{
                list=data.getStringArrayListExtra("result");
                adapter=new ArrayAdapter(ConfirmOrder.this,android.R.layout.simple_list_item_1,list);
                passengers.setAdapter(adapter);
                break;
            }
        }
    }
}
