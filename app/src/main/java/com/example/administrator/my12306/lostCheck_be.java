package com.example.administrator.my12306;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lostCheck_be extends AppCompatActivity implements View.OnClickListener{
private Button agree,disagree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_check_be);
        agree=findViewById(R.id.agree_lost);
        disagree=findViewById(R.id.disagree_lost);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.disagree_lost:finish();
            break;
            case R.id.agree_lost:{
                Intent intent=new Intent(lostCheck_be.this,lostCheck.class);
                //点击确认按钮后跳转到正式的失物信息界面
                //点击不同意，退出当前活动
            }
        }
    }
}
