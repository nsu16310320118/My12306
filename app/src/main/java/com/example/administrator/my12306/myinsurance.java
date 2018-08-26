package com.example.administrator.my12306;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Date;

public class myinsurance extends AppCompatActivity {
private EditText startDate,endDate,insuranceNumber;
private Button inquiry;
private Date dateStart,dateEnd;
private String insuranceNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinsurance);
        startDate=findViewById(R.id.startDate);
        endDate=findViewById(R.id.endDate);
        insuranceNumber=findViewById(R.id.insuranceNumber);
        inquiry=findViewById(R.id.inquiry_insurance);
        insuranceNum=insuranceNumber.getText().toString();
        inquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //根据起始，结束时间或保险单号查询保险
            }
        });
    }
}
