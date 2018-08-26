package com.example.administrator.my12306;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class warmprompt extends AppCompatActivity implements View.OnClickListener{
private TextView serveCheck,lostCheck,VIPorder,complaint,advise,servePhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warmprompt);
        serveCheck=findViewById(R.id.serveCheck);
        lostCheck=findViewById(R.id.lostCheck);
        VIPorder=findViewById(R.id.VIPorder);
        complaint=findViewById(R.id.complaint);
        advise=findViewById(R.id.advise);
        servePhone=findViewById(R.id.servePhone);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.serveCheck:{
                intent=new Intent(warmprompt.this,serveCheck.class);
                break;
            }
            case R.id.lostCheck:{
                intent=new Intent(warmprompt.this,lostCheck.class);
                break;
            }
            case R.id.VIPorder:{
                Toast.makeText(this,"你点击了VIP预定",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.complaint:{
                Toast.makeText(this,"你选择了投诉",Toast.LENGTH_LONG).show();
                break;
            }
            case  R.id.advise:{
                intent=new Intent(warmprompt.this,advise.class);
                break;
            }
            case R.id.servePhone:{
                Toast.makeText(this,"你选择了热线电话",Toast.LENGTH_LONG).show();
                break;
            }
        }
    }
}
