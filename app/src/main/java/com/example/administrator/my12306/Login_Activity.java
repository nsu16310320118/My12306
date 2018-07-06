package com.example.administrator.my12306;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {
private EditText textUserName,textPassword;
private TextView forget;
private Button login,register;
private CheckBox remember;
private String userName,passWord;
private myDatabase myDatabase;
private SQLiteDatabase db;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        textUserName.setText(data.getStringExtra(""));
        textPassword.setText(data.getStringExtra(""));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        textUserName=findViewById(R.id.editUserName);
        textPassword=findViewById(R.id.editPassword);
        login=findViewById(R.id.login);
        register=findViewById(R.id.register);
        remember=findViewById(R.id.remember);
        forget=findViewById(R.id.forget);
        myDatabase=new myDatabase(this,"UserMessage.db",null,1);
        db=myDatabase.getReadableDatabase();
        userName=textUserName.getText().toString();
        passWord=textPassword.getText().toString();
        //--------------------------
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login_Activity.this,forgetPwd_Activity.class);
                if(!TextUtils.isEmpty(userName)){
                    intent.putExtra("username",userName);
                }
                else {
                    intent.putExtra("username","");
                }
                startActivity(intent);
            }
        });//跳转到忘记密码界面

        login.setOnClickListener(new View.OnClickListener() {
            boolean isin=false;
//            private String strUserName=textUserName.getText().toString();
//            private String strPassWord=textPassword.getText().toString();
            @Override
            public void onClick(View view) {
                //跳转到主界面
                if(TextUtils.isEmpty(userName)){
                    textUserName.setError("输入用户名为空");
                    textUserName.requestFocus();
                }
                else if(TextUtils.isEmpty(passWord)){
                    textPassword.setError("输入密码为空");
                    textPassword.requestFocus();
                }
                else {
                    Intent intent = new Intent(Login_Activity.this, MainActivity.class);
                    startActivity(intent);
                }
//                isin=ifitInDB(strUserName,strPassWord);
//                if(isin){
//                    //用户存在于数据库内，跳转到主界面
//                    Intent intent=new Intent(Login_Activity.this,MainActivity.class);
//                    startActivity(intent);
//                }
//                else {
//                    textUserName.setError("账户或密码存在问题，请检查并重新输入");
//                    textUserName.requestFocus();
//                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login_Activity.this,Register_Activity.class);
                startActivityForResult(intent,1);
            }
        });
    }
    public boolean ifitInDB(String strUserName,String strPassWord){
        boolean flag=false;
        String name=strUserName;
        String password=strPassWord;
        String sql="Select PassWord from myUser where UserName=?";
        Cursor cursor=db.rawQuery(sql,new String[]{name});
        if(cursor.moveToFirst()){
            String getpwd=cursor.getString(cursor.getColumnIndex("PassWord"));
            if(getpwd.equals(password)){
                flag=true;
            }
        }
        return  flag;
    }
}
