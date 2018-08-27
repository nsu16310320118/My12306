package com.example.administrator.my12306;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class warmprompt extends AppCompatActivity {
    private TextView serveCheck, lostCheck, VIPorder, complaint, advise, servePhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warmprompt);
        serveCheck = findViewById(R.id.serveCheck);
        serveCheck.setOnClickListener(new warmpromptListener());
        lostCheck = findViewById(R.id.lostCheck);
        lostCheck.setOnClickListener(new warmpromptListener());
        VIPorder = findViewById(R.id.VIPorder);
        VIPorder.setOnClickListener(new warmpromptListener());
        complaint = findViewById(R.id.complaint);
        complaint.setOnClickListener(new warmpromptListener());
        advise = findViewById(R.id.advise);
        advise.setOnClickListener(new warmpromptListener());
        servePhone = findViewById(R.id.servePhone);
        servePhone.setOnClickListener(new warmpromptListener());
    }

    private class warmpromptListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent;
            switch (view.getId()) {
                case R.id.serveCheck: {
                    intent = new Intent(warmprompt.this, serveCheck.class);
                    startActivity(intent);
                    break;
                }
                case R.id.lostCheck: {
                    intent = new Intent(warmprompt.this, lostCheck.class);
                    startActivity(intent);
                    break;
                }
                case R.id.VIPorder: {
                    Toast.makeText(warmprompt.this, "你点击了VIP预定", Toast.LENGTH_LONG).show();
                    break;
                }
                case R.id.complaint: {
                    Toast.makeText(warmprompt.this, "你选择了投诉", Toast.LENGTH_LONG).show();
                    break;
                }
                case R.id.advise: {
                    intent = new Intent(warmprompt.this, advise.class);
                    startActivity(intent);
                    break;
                }
                case R.id.servePhone: {
                    Toast.makeText(warmprompt.this, "你选择了热线电话", Toast.LENGTH_LONG).show();
                    break;
                }
            }
        }
    }
}
