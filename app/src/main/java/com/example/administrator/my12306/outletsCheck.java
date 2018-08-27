package com.example.administrator.my12306;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class outletsCheck extends AppCompatActivity {
private EditText provience,city,county;
private Button inquiry;
private String strProvience,strCity,StrCounty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outlets_check);
        provience=findViewById(R.id.provience);
        city=findViewById(R.id.city);
        county=findViewById(R.id.county);
            strProvience=provience.getText().toString();
            strCity=city.getText().toString();
            StrCounty=county.getText().toString();
//      inquiry.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View view) {
//              //通过省市县查询代售点
//          }
//      });
    }
}
