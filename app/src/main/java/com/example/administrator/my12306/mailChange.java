package com.example.administrator.my12306;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mailChange extends AppCompatActivity implements View.OnClickListener{
private EditText email,password,messageCheck;
private Button messageButton,sure_mes;
private String checkMes,newEmail,pwdCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_change);
        email=findViewById(R.id.email_change);
        password=findViewById(R.id.email_password);
        messageCheck=findViewById(R.id.messageCheck);
        messageButton=findViewById(R.id.messageButton);
        sure_mes=findViewById(R.id.sure_mes);
        checkMes=messageCheck.getText().toString();
        newEmail=email.getText().toString();
        pwdCheck=password.getText().toString();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.messageButton://向服务器发送请求，从服务端发送一个验证码过来
                break;
            case R.id.sure_mes:
                //检查服务端发来的验证码与checkMes,是否相同，检查密码是否与数据库中一致，相同则将数据库中该用户的邮箱号改为email中信息
                break;
        }
    }
}
