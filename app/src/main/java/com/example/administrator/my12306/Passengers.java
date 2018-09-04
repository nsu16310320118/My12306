package com.example.administrator.my12306;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.administrator.my12306.AddPassengers;
import com.example.administrator.my12306.R;

public class Passengers extends AppCompatActivity {

    private EditText edtName;
    private ImageButton ibtnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passengers);

        edtName = (EditText) findViewById(R.id.edtName);
        ibtnAdd = (ImageButton) findViewById(R.id.ibtnAdd);

        ibtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Passengers.this, AddPassengers.class);
//                startActivityForResult(intent,1);
                startActivity(intent);
            }
        });
    }
}
