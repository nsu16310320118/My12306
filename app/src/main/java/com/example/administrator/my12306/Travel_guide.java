package com.example.administrator.my12306;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Travel_guide extends AppCompatActivity {
    private TextView timeCheck, trainCheck, fareCheck, outletsCheck, stationCheck, saleCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_guide);
        timeCheck = findViewById(R.id.timeCheck);
        timeCheck.setOnClickListener(new guideListener());
        trainCheck = findViewById(R.id.trainCheck);
        trainCheck.setOnClickListener(new guideListener());
        fareCheck = findViewById(R.id.fareCheck);
        fareCheck.setOnClickListener(new guideListener());
        outletsCheck = findViewById(R.id.outletsCheck);
        outletsCheck.setOnClickListener(new guideListener());
        stationCheck = findViewById(R.id.stationCheck);
        stationCheck.setOnClickListener(new guideListener());
        saleCheck = findViewById(R.id.saleCheck);
        saleCheck.setOnClickListener(new guideListener());
    }

    private class guideListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //同样根据不同事件进入不同页面
            Intent intent;
            switch (view.getId()) {
                case R.id.timeCheck: {
                    intent = new Intent(Travel_guide.this, timeCheck.class);
                    startActivity(intent);
                    break;
                }
                case R.id.trainCheck: {
                    intent = new Intent(Travel_guide.this, trainCheck.class);
                    startActivity(intent);
                    break;
                }
                case R.id.fareCheck: {
                    intent = new Intent(Travel_guide.this, fareCheck_not_do.class);
                    startActivity(intent);
                    break;
                }
                case R.id.outletsCheck: {
                    intent = new Intent(Travel_guide.this, outletsCheck.class);
                    startActivity(intent);
                    break;
                }
                case R.id.stationCheck: {
                    intent = new Intent(Travel_guide.this, stationCheck_unfinished.class);
                    startActivity(intent);
                    break;
                }
                case R.id.saleCheck: {
                    intent = new Intent(Travel_guide.this, saleCheck.class);
                    startActivity(intent);
                    break;
                }
            }
        }
    }
}
