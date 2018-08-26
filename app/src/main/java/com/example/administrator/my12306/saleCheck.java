package com.example.administrator.my12306;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class saleCheck extends AppCompatActivity {
private EditText station;
private Button inquiry;
private String strStaion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_check);
        station=findViewById(R.id.station_sale);
        inquiry=findViewById(R.id.inquiry_sale);
        strStaion=station.getText().toString();
        inquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //通过车站查找已买的票
            }
        });
    }
}
