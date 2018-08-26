package com.example.administrator.my12306;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class timeCheck extends AppCompatActivity {
private EditText station,trainNumber;
private Button inquiry;
private String strStaion,strTrainNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_check);
        station=findViewById(R.id.station_time);
        trainNumber=findViewById(R.id.trainNumber_time);
        strStaion=station.getText().toString();
        strTrainNumber=trainNumber.getText().toString();
        inquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //由上述数据查询相关信息
            }
        });
    }
}
