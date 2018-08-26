package com.example.administrator.my12306;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class personal_data extends AppCompatActivity {
private EditText userName,name,gender,birthday,country,idType,idNumber,state;
private EditText phoneNumber,tellPhone,email,address,postNumber,passengerType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);
        userName=findViewById(R.id.userName_person);
        name=findViewById(R.id.name_person);
        gender=findViewById(R.id.gender);
        birthday=findViewById(R.id.birthday);
        country=findViewById(R.id.country);
        idType=findViewById(R.id.idType_person);
        idNumber=findViewById(R.id.idNumber_person);
        state=findViewById(R.id.state);
        phoneNumber=findViewById(R.id.phoneNumer_person);
        tellPhone=findViewById(R.id.tellphone);
        email=findViewById(R.id.email_person);
        address=findViewById(R.id.address);
        postNumber=findViewById(R.id.postNumer);
        passengerType=findViewById(R.id.passengerType_person);
        //需要在数据库中保存在该界面显示，修改
    }
}
