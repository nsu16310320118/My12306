package com.example.administrator.my12306;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Register_Activity extends AppCompatActivity {
private EditText userMessage,rePassword,reCheckPassword,reName,IDNumber;
private EditText phoneNumber,email;
private TextView passengerType,type;
private CheckBox agree;
private Button next;
private myDatabase db;
private SQLiteDatabase mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);
        userMessage=findViewById(R.id.reUsername);
        rePassword=findViewById(R.id.rePassWord);
        reCheckPassword=findViewById(R.id.reCheckPassword);
        reName=findViewById(R.id.reName);
        type=findViewById(R.id.type);
        IDNumber=findViewById(R.id.IDNumber);
        phoneNumber=findViewById(R.id.phoneNumber);
        email=findViewById(R.id.email);
        passengerType=findViewById(R.id.PassengerType);
        agree=findViewById(R.id.agree);
        next=findViewById(R.id.next);
        db=new myDatabase(this,"UserMessage.db",null,1);
        mydatabase=db.getWritableDatabase();
        //-----------------------------------
        passengerType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击后弹出菜单选择乘客类型
            }
        });

        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击后跳转到用户守则界面，只用实现跳转，守则界面内容内容不实现
            }
        });
        type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击后弹出菜单显示证件类型选择
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //检查数据的类型，检查完成后将数据加入到数据库之中
            }
        });
    }
}
