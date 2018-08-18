package com.example.administrator.my12306;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class phoneCheck extends AppCompatActivity {
private Button changePhoneNum;
    @Override
    //做检查是否已核验手机，选择进入相应界面
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_check);
        changePhoneNum=findViewById(R.id.changePhoneNum);
        changePhoneNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
