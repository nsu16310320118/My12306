package com.example.administrator.my12306;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.BuddhistCalendar;
import android.os.UserManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        email=findViewById(R.id.email_change);
        passengerType=findViewById(R.id.PassengerType);
        agree=findViewById(R.id.agree);
        next=findViewById(R.id.next);
        db=new myDatabase(this,"UserMessage.db",null,1);
        mydatabase=db.getReadableDatabase();
        //-----------------------------------
        passengerType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击后弹出菜单选择乘客类型
                AlertDialog.Builder tbuilder = new AlertDialog.Builder(Register_Activity.this);
                final String[] tour = {"成人", "儿童", "学生", "残军"};
                tbuilder.setSingleChoiceItems(tour, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        passengerType.setText(tour[i]);
                        dialogInterface.dismiss();
                    }
                });
                tbuilder.show();
            }
        });
        type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] card = {"二代身份证", "港澳居民来往内地通行证", "台湾居民来往大陆通行证", "护照"};
                AlertDialog.Builder cbuilder = new AlertDialog.Builder(Register_Activity.this);
                cbuilder.setSingleChoiceItems(card, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        type.setText(card[i]);
                        dialogInterface.dismiss();
                    }
                });
                cbuilder.show();
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            //点击按键以后，每一个框做自查
            StringBuilder stringBuilder=new StringBuilder();
            @Override
            public void onClick(View view) {
                stringBuilder.delete(0,stringBuilder.length());
                String str="^[a-zA-Z][a-zA-Z0-9_]{5,30}$";
                Pattern pattern=Pattern.compile(str);
                Matcher matcher=pattern.matcher(userMessage.getText().toString());
                String string=matcher.replaceAll("").trim();
                if(!userMessage.getText().toString().equals(string)){
                    stringBuilder.append("您输入的名称不合法\n");
                }
                String regexPwd="^\\w+$";
                Pattern pwdpattern=Pattern.compile(regexPwd);
                Matcher pwdmatcher=pwdpattern.matcher(rePassword.getText().toString());
                String pwdString=pwdmatcher.replaceAll("").trim();
                if(!rePassword.getText().toString().equals(pwdString)){
                    stringBuilder.append("密码内容不合法\n");
                }
                if(TextUtils.isEmpty(rePassword.getText())){
                    stringBuilder.append("请输入密码\n");
                }
                if(rePassword.getText().length()<6){
                    stringBuilder.append("密码最少为6位\n");
                }

                if(!TextUtils.equals(rePassword.getText(),reCheckPassword.getText())||TextUtils.isEmpty(reCheckPassword.getText())||reCheckPassword.getText().length()<6){
                    stringBuilder.append("重新输入密码错误\n");
                }
                 if(TextUtils.isEmpty(IDNumber.getText())){
                     stringBuilder.append("请输入您的身份证号码\n");
                 }
                 if(TextUtils.isEmpty(phoneNumber.getText())){
                     stringBuilder.append("请输入您的手机号码\n");
                 }
                 if(phoneNumber.getText().length()<18){
                     stringBuilder.append("请输入正确的手机号\n");
                 }
                 if(TextUtils.isEmpty(email.getText())){
                     stringBuilder.append("请输入您的电子邮箱号码\n");
                 }
                 if(!agree.isChecked()){
                     stringBuilder.append("请阅读服务条款\n");
                 }
                 if(!TextUtils.isEmpty(stringBuilder.toString())){
                     AlertDialog.Builder builder=new AlertDialog.Builder(Register_Activity.this);
                     builder=new AlertDialog.Builder(Register_Activity.this);
                     builder.setTitle("温馨提示");
                     builder.setMessage(stringBuilder.toString());
                     builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                             dialogInterface.dismiss();
                         }
                     });
                     builder.show();
                 }

                 }
        }
        );

    }
}
