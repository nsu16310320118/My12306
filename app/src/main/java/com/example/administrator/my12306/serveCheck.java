package com.example.administrator.my12306;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class serveCheck extends AppCompatActivity {
private EditText serveType,dateType,goOff,endTime;
private Button inquiry;
private String strServeType,strDateType,strGoOff,strEndTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serve_check);
        serveType=findViewById(R.id.serveType);
        dateType=findViewById(R.id.dateType);
        goOff=findViewById(R.id.go_off);
        endTime=findViewById(R.id.end_time);
        inquiry=findViewById(R.id.inquiry_serve);
        strServeType=serveType.getText().toString();
        strDateType=dateType.getText().toString();
        strGoOff=goOff.getText().toString();
        strEndTime=endTime.getText().toString();

        inquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //上传上面相关数据查询服务
            }
        });
    }
}
