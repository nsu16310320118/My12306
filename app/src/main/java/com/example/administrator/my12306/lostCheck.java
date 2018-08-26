package com.example.administrator.my12306;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class lostCheck extends AppCompatActivity {
private EditText passenger,takeMes,gender,phoneNumber,idType,idNumber,date,trainNumber;
private EditText goStation,endStation,carriageNumber,seatNumber,whereLost,place,other;
private Button upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_check);
        passenger=findViewById(R.id.passenger);
        takeMes=findViewById(R.id.takeMes);
        gender=findViewById(R.id.gender);
        phoneNumber=findViewById(R.id.phoneNumber_lost);
        idType=findViewById(R.id.idType_lost);
        idNumber=findViewById(R.id.idNumber_lost);
        date=findViewById(R.id.date);
        trainNumber=findViewById(R.id.train_number);
        goStation=findViewById(R.id.goStation);
        endStation=findViewById(R.id.endStation);
        carriageNumber=findViewById(R.id.carriageNumber);
        seatNumber=findViewById(R.id.seatNumber);
        whereLost=findViewById(R.id.whereLost);
        place=findViewById(R.id.place);
        other=findViewById(R.id.other_lost);
        upload=findViewById(R.id.upload_lost);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击后将各数据上传到数据库
            }
        });

    }
}
