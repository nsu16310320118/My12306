package com.example.administrator.my12306;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class pwdChange extends AppCompatActivity {
private EditText original,newPwd,reNew,messageCheck;
private Button messageButton,sure;
private String strOrigin,strNewPwd,strReNew,strMessageCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwd_change);
        original=findViewById(R.id.original);
        newPwd=findViewById(R.id.newPwd);
        reNew=findViewById(R.id.reNew);
        messageCheck=findViewById(R.id.messageCheck_pwd);
        messageButton=findViewById(R.id.messageButton_pwd);
        sure=findViewById(R.id.sure_pwd);
        strOrigin=original.getText().toString();
        strNewPwd=newPwd.getText().toString();
        strReNew=reNew.getText().toString();
        strMessageCheck=messageCheck.getText().toString();

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击后向服务器要验证码
            }
        });
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击后做密码检验，是否和上次的相同，验证码是否正确，确认密码与密码栏是否相同
                //更改数据库栏密码中的数据
            }
        });
    }
}
