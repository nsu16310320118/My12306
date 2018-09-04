package com.example.administrator.my12306;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class order_ticket extends AppCompatActivity {
    private TopBar topBar;
    private ListView timeTable;
    private TextView orderTime;
    private static String fromCity, toCity, goDate;
    private TrainListAdapter adapter;
    private List<order_ticket.Number> trainNumber = new ArrayList<order_ticket.Number>();

    //private String[] trainNumber={"G131","G133","G135","G137","G139","G141","G143"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_ticket);
        LayoutInflater factory = LayoutInflater.from(order_ticket.this);
        View layout = factory.inflate(R.layout.train_number, null);
        topBar = findViewById(R.id.topbar);
        orderTime = findViewById(R.id.order_time);
        timeTable = findViewById(R.id.trianListView);
        initTrainNumber();
        adapter = new TrainListAdapter(this, R.layout.train_number, trainNumber);
        timeTable.setAdapter(adapter);
        timeTable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(order_ticket.this,"你点击对了",Toast.LENGTH_LONG).show();
                //把点击的车次传送过去
            }
        });
        topBar.setOnLeftAndRightClickListener(new TopBar.OnLeftAndRightClickListener() {
            @Override
            public void OnLeftButtonClick() {
                finish();
            }

            @Override
            public void OnRightButtonClick() {
            }
        });
        Intent intent = getIntent();
        fromCity = intent.getStringExtra("fromCity");
        toCity = intent.getStringExtra("toCity");
        goDate = intent.getStringExtra("goDate");
        topBar.setTitleTextView(fromCity + "->" + toCity);
        orderTime.setText(goDate);

    }

    private void initTrainNumber() {
        Number number;
        for (int i = 0; i < 10; i++) {
            number = new Number("G12" + i);
            trainNumber.add(number);
            Log.i("NUM",Number.getNumber());
        }
    }

    public static String getFromCity() {
        return fromCity;
    }

    public static String getToCity() {
        return toCity;
    }

    public static class Number {//车次类
        private static String number;

        public Number(String number) {
            this.number = number;
        }

        public static String getNumber() {
            return number;
        }
    }

}
