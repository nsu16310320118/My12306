package cn.edu.nsu.a12306_program;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrainDetail extends AppCompatActivity {
    private List trainNumber=new ArrayList<Number>();
    private String CheNo;

    private JSONObject jsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_list);


        final TrainListAdapter adapter = new TrainListAdapter(this, R.layout.train_number, trainNumber);
        final ListView trainListView = (ListView) findViewById(R.id.trianListView);

        trainListView.setAdapter(adapter);

        Intent intent=getIntent();
        String result=intent.getStringExtra("trainInfo");



        trainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TrainDetail.this, ConfirmOrder.class);

                TrainInfo number = (TrainInfo) trainNumber.get(i);
                CheNo = number.getTrainNo();
                intent.putExtra("Checi",CheNo);
                startActivityForResult(intent, 1);
            }
        });
    }

    private List<TrainInfo> orginJson(String json) throws JSONException {//JSON解析
        List<TrainInfo> list=new ArrayList<TrainInfo>();
        JSONArray jsonArray=new JSONArray(json);
        for (int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            TrainInfo trainInfo=new TrainInfo();
            trainInfo.setTrainNo(jsonObject.getString("trainNo"));
            trainInfo.setFromCity(jsonObject.getString("fromStationName"));
            trainInfo.setToCity(jsonObject.getString("toStationName"));
            trainInfo.setStartTime(jsonObject.getString("startTime"));
            trainInfo.setArriveTime(jsonObject.getString("arriveTime"));
            trainInfo.setDurationTime(jsonObject.getString("durationTime"));
            list.add(trainInfo);
        }
        return list;
    }

}
