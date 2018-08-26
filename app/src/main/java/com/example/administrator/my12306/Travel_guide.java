package com.example.administrator.my12306;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Travel_guide extends AppCompatActivity implements View.OnClickListener{
private TextView timeCheck,trainCheck,fareCheck,outletsCheck,stationCheck,saleCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_guide);
        timeCheck=findViewById(R.id.timeCheck);
        trainCheck=findViewById(R.id.trainCheck);
        fareCheck=findViewById(R.id.fareCheck);
        outletsCheck=findViewById(R.id.outletsCheck);
        stationCheck=findViewById(R.id.stationCheck);
        saleCheck=findViewById(R.id.saleCheck);
    }

    @Override
    public void onClick(View view) {
        //同样根据不同事件进入不同页面
        Intent intent;
        switch (view.getId()){
            case R.id.timeCheck:{
                intent=new Intent(Travel_guide.this,timeCheck.class);
                break;
            }
            case R.id.trainCheck:{
                intent=new Intent(Travel_guide.this,trainCheck.class);
                break;
            }
            case R.id.fareCheck:{
                intent=new Intent(Travel_guide.this,fareCheck_not_do.class);
                break;
            }
            case R.id.outletsCheck:{
                intent=new Intent(Travel_guide.this,outletsCheck.class);
                break;
            }
            case R.id.stationCheck:{
                intent=new Intent(Travel_guide.this,stationCheck_unfinished.class);
                break;
            }
            case R.id.saleCheck:{
                intent=new Intent(Travel_guide.this,saleCheck.class);
                break;
            }
        }
    }
}
