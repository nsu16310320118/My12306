package com.example.administrator.my12306;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class usually extends AppCompatActivity {
private ListView listView;
private ListAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usually);
        //从数据库中调取该账号使用过的乘客名单
        listView=findViewById(R.id.listView);
        myAdapter=listView.getAdapter();
    }
}
