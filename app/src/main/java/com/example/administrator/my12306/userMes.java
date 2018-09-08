package com.example.administrator.my12306;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class userMes extends AppCompatActivity implements View.OnClickListener{
private TextView usually_use,ticket_add,myMes,Notification_Settings,pwdChange,emailChange;
private Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_mes);
        usually_use=findViewById(R.id.usually_use);
        ticket_add=findViewById(R.id.ticket_add);
        myMes=findViewById(R.id.myMes);
        Notification_Settings=findViewById(R.id.Notification_Settings);
        pwdChange=findViewById(R.id.pwdChange);
        emailChange=findViewById(R.id.emailChange);
    }

    @Override
    public void onClick(View view) {
        //根据点击的对象不同，进入不同的活动
        Intent intent;
        switch (view.getId()){
            case R.id.usually_use:{
                intent=new Intent(userMes.this,usually.class);//数据库完成后添加
                break;
            }
            case R.id.ticket_add:{
                //后续添加
                Toast.makeText(this,"你点击了地址",Toast.LENGTH_LONG).show();
                break;
            }
            case  R.id.myMes:{
                intent=new Intent(userMes.this,personal_data.class);
                break;
            }
            case  R.id.Notification_Settings:{
                Toast.makeText(this,"你点击了通知修改",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.pwdChange:{
                intent=new Intent(userMes.this,pwdChange.class);
                break;
            }
            case R.id.emailChange:{
                intent=new Intent(userMes.this,mailChange.class);
                break;
            }
            case R.id.exit:{
                //执行账号退出操作
            }
        }
    }

    public static class NetUtils {
        public static boolean check(Context context){
                try {
                    ConnectivityManager connectivity = (ConnectivityManager) context
                            .getSystemService(CONNECTIVITY_SERVICE);
                    if (connectivity != null) {
                        // 获取网络连接管理的对象
                        NetworkInfo info = connectivity.getActiveNetworkInfo();
                        if (info != null && info.isConnected()) {
                            // 判断当前网络是否已经连接
                            if (info.getState() == NetworkInfo.State.CONNECTED) {
                                return true;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        }
}
