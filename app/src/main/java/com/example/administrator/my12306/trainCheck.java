package com.example.administrator.my12306;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class trainCheck extends AppCompatActivity {
private EditText trainNumber,goOff;
private Button inquiry;
private String strTrainNumber,strGoOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_check);
        trainNumber=findViewById(R.id.trainNumber_train);
        goOff=findViewById(R.id.go_off_train);
        inquiry=findViewById(R.id.inquiry_train);
        strTrainNumber=trainNumber.getText().toString();
        strGoOff=goOff.getText().toString();
        inquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //根据车次和开车时间查询
            }
        });
    }
}
