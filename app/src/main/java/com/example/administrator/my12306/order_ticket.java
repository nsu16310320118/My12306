package com.example.administrator.my12306;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class order_ticket extends AppCompatActivity {
    private TopBar topBar;
    private ListView timeTable;
    private TextView orderTime;
    private static String fromCity, toCity, goDate;
    private TrainListAdapter adapter;
    private List<TrainInfo> trainNumber = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_ticket);
        LayoutInflater factory = LayoutInflater.from(order_ticket.this);
        View layout = factory.inflate(R.layout.train_number, null);
        topBar = findViewById(R.id.topbar);
        orderTime = findViewById(R.id.order_time);
        timeTable = findViewById(R.id.trianListView);
        topBar.setOnLeftAndRightClickListener(new TopBar.OnLeftAndRightClickListener() {
            @Override
            public void OnLeftButtonClick() {
                finish();
            }

            @Override
            public void OnRightButtonClick() {
            }
        });
        Intent intent = getIntent();
        fromCity = intent.getStringExtra("fromCity");
        toCity = intent.getStringExtra("toCity");
        goDate = intent.getStringExtra("goDate");
        topBar.setTitleTextView(fromCity + "->" + toCity);
        orderTime.setText(goDate);
                    //将消息发送给服务器,服务器返回查询结果，生成列表显示
        new Thread(){
            public void run(){
                URL url= null;
                try {
                    url = new URL(CONSTANT.HOST+"/otn/TrainList");
                    HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");//设置请求方法
                    SharedPreferences preferences=order_ticket.this.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                    connection.setRequestProperty("cookie",preferences.getString("cookie",""));
                    connection.setConnectTimeout(CONSTANT.REQUEST_TIMEOUT);//设置连接超时
                    connection.setReadTimeout(CONSTANT.SO_TIMEOUT);//设置读取超时
                    //设置允许输入输出
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    //获取httpUrlConnection的输出流
                    PrintWriter printWriter = new PrintWriter( connection.getOutputStream());
                    String params = "fromStationName="+fromCity
                            +"&toStationName="+ toCity+"&startTrainDate="+goDate;
                    //发送参数
                    System.out.println("发往服务器的参数"+params);
                    printWriter.write(params);
                    printWriter.flush();
                    printWriter.close();
                    //获取响应状态
                    int reponseCode = connection.getResponseCode();
                    if(reponseCode == HttpURLConnection.HTTP_OK){
                        //打开输入流
                        StringBuilder sb = new StringBuilder();
                        String line = "";
                        BufferedReader bufferedReader = new BufferedReader(
                                new InputStreamReader(connection.getInputStream()));
                        while ((line = bufferedReader.readLine())!=null){
                            sb.append(line).append("\n");
                        }
                        System.out.println("服务器返回的信息："+sb.toString());
                        bufferedReader.close();
                        trainNumber=orginJson(sb.toString());
                    }else {
                        System.out.println("服务器返回的信息出错："+connection.getResponseCode());
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                adapter = new TrainListAdapter(order_ticket.this, R.layout.train_number, trainNumber);
                timeTable.setAdapter(adapter);
                timeTable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(order_ticket.this, ConfirmOrder.class);
                        intent.putExtra("fromCity", fromCity);
                        intent.putExtra("toCity", toCity);
                        intent.putExtra("goDate", goDate);
                        intent.putExtra("trainNumber",trainNumber.get(i).trainNo);
                        intent.putExtra("goTime",trainNumber.get(i).startTime);
                        intent.putExtra("endTime",trainNumber.get(i).arriveTime);
                        startActivity(intent);
                        //把点击的车次传送过去
                    }
                });
            }
        }.start();
    }
    public List<TrainInfo> orginJson(String json) {//JSON解析
        List<TrainInfo> list = new ArrayList<TrainInfo>();
        JSONArray object = null;
        try {
            object = new JSONArray(json);
            for (int i = 0; i < object.length(); i++) {
                TrainInfo trainInfo = new TrainInfo();
                JSONObject jsonObject = (JSONObject) object.getJSONObject(i);//得到第某一json对象
                trainInfo.setTrainNo((jsonObject.getString("trainNo")));
                trainInfo.setFromCity(jsonObject.getString("fromStationName"));
                trainInfo.setToCity(jsonObject.getString("toStationName"));
                trainInfo.setStartTime(jsonObject.getString("startTime"));
                trainInfo.setArriveTime(jsonObject.getString("arriveTime"));
                trainInfo.setDurationTime(jsonObject.getString("durationTime"));
                list.add(trainInfo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

}

