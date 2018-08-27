package com.example.administrator.my12306;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class from extends AppCompatActivity {
private ListView from;
private String[] place={"成都","青城山","北京"};
private ArrayAdapter myAdapter_from;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from);
        from=findViewById(R.id.listView_from);
        myAdapter_from=new ArrayAdapter(from.this,android.R.layout.simple_list_item_1);
        from.setAdapter(myAdapter_from);

        from.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String site=place[i];
                Intent intent=new Intent();
                intent.putExtra("site",site);
                setResult(2);
            }
        });
    }
}
