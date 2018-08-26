package com.example.administrator.my12306;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class advise extends AppCompatActivity {
private EditText name,phoneNumber,idType,idNumber,toWho,detail;
private Button upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advise);
        name=findViewById(R.id.name);
        phoneNumber=findViewById(R.id.phoneNumber);
        idType=findViewById(R.id.idType);
        idNumber=findViewById(R.id.idNumber);
        toWho=findViewById(R.id.toWho);
        detail=findViewById(R.id.detail);
        upload=findViewById(R.id.upload);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //将信息上传建议接收的地方，用数据库进行保存
                //可能需要专门的建议数据库
            }
        });
    }
}
