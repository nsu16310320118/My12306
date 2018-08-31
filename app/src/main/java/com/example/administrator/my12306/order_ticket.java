package com.example.administrator.my12306;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.PopupMenu;
import android.widget.Toast;

public class order_ticket extends AppCompatActivity {
TopBar topBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_ticket);
        topBar=findViewById(R.id.topbar);
        topBar.setOnLeftAndRightClickListener(new TopBar.OnLeftAndRightClickListener() {
            @Override
            public void OnLeftButtonClick() {
                finish();
            }

            @Override
            public void OnRightButtonClick() {
            }
        });
        Intent intent=getIntent();
        String fromCity=intent.getStringExtra("fromCity");
        String toCity=intent.getStringExtra("toCity");
        topBar.setTitleTextView(fromCity+"->"+toCity);
    }
}
