package com.example.administrator.my12306;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class forgetPwd_Activity extends AppCompatActivity {
private EditText userName,key,password,checkPasword,phoneNumber;
Button getKey,confirm,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd_);
        userName=findViewById(R.id.editUserName);
        key=findViewById(R.id.editKey);
        password=findViewById(R.id.editPassword);
        checkPasword=findViewById(R.id.editCheckPwd);
        phoneNumber=findViewById(R.id.phone);
        getKey=findViewById(R.id.key);
        confirm=findViewById(R.id.confirm);;
        cancel=findViewById(R.id.cancel);
//---------------------------------------------------------
        Intent intent=getIntent();
        userName.setText(intent.getStringExtra("username"));
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(TextUtils.equals(password.getText().toString(),checkPasword.getText().toString())){
                        //改变数据库内的密码栏，确认key栏是否是6位数字，password,checkPassword是否相等
                    }
            }
        });
        getKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送一条短信，内容包含六位数字
            }
        });


    }
}
