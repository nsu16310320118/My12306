package com.example.aurora.t12306;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

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

        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击后跳转到用户守则界面，只用实现跳转，守则界面内容内容不实现
                Intent intent =new Intent(Register_Activity.this,Login_Activity.class);
                intent.putExtra("phone",phoneNumber.getText().toString());
                startActivity(intent);
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
            @Override
            public void onClick(View view) {
                //检查数据的类型，检查完成后将数据加入到数据库之中
                final AlertDialog.Builder builder=new AlertDialog.Builder(Register_Activity.this);
                builder.setTitle("温馨提示");
                switch (view.getId()){
                    case R.id.reUsername:
                        String str="^[a-zA-Z][a-zA-Z0-9_]{5,30}$";
                        Pattern pattern=Pattern.compile(str);
                        if (!pattern.matcher(str).matches()){
                            builder.setMessage("用户名只能填写字母下划线，开头必须为字母，且长度必须在6-30位内")；
                        }
                        break;
                    case R.id.rePassword:
                        String s="^\\w+$";
                        Pattern p=Pattern.compile(s);
                        if (!p.matcher(s).matches()){
                            builder.setMessage("密码格式错误，必须且只能包含字母，数字，下划线中的两种或两种以上")；
                            break;
                        }
                        if (rePassword.length()<6){
                            builder.setMessage("密码不能少于6位");
                        }
                        break;
                    case R.id.reCheckPassword:
                        if (!rePassword.getText().toString().equals(reCheckPassword.getText().toString())){
                            builder.setMessage("确认密码与密码不一致");
                        }
                        break;
                    case R.id.reName:
                        if (TextUtils.isEmpty(reName.getText().toString())){
                            builder.setMessage("请正确输入姓名");
                        }
                        break;
                    case R.id.phoneNumber:
                        if (TextUtils.isEmpty(phoneNumber.getText().toString())){
                            builder.setMessage("请输入手机号码");
                            break;
                        }
                        if(phoneNumber.length()!=11){
                            builder.setMessage("请输入正确的手机号码");
                        }
                        break;
                    case R.id.IDNumber:
                        if (TextUtils.isEmpty(IDNumber.getText().toString())){
                            builder.setMessage("请输入身份证号码");
                            break;
                        }
                        if(IDNumber.length()!=18){
                            builder.setMessage("请正确输入18位的身份证号");
                        }
                        break;
                    case R.id.agree:
                        builder.setMessage("同意服务条款才能注册");
                        break;
                }
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();

            }
        });
    }
}
