package com.example.administrator.my12306;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class today_s_order extends AppCompatActivity {
List<String> result;
private ListView resultList;
private ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_s_order);
        resultList=findViewById(R.id.resultList);
        //运用查询语句将今日订单查询后用listView展示在活动内
    }
}
