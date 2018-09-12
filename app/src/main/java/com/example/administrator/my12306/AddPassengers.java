package com.example.administrator.my12306;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AddPassengers extends AppCompatActivity {
    private ArrayList passengerList=new ArrayList<Passenger>();
    private ArrayList result=new ArrayList<>();
    private TopBarForP topBarForP;
    private ListView passengers;
    private ImageView addbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_passengers);
        addbtn=findViewById(R.id.ibtnAdd);
        passengers=findViewById(R.id.passengerList);

        topBarForP=findViewById(R.id.topbarforp);
        topBarForP.setTitleTextView("添加乘客");
       topBarForP.setOnLeftAndRightClickListener(new TopBarForP.OnLeftAndRightClickListener() {
           @Override
           public void OnLeftButtonClick() {
               finish();
           }

           @Override
           public void OnRightButtonClick() {
                Intent intent=getIntent();
                intent.putExtra("result",result);
                setResult(0x101,intent);
                finish();
           }
       });
       addbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                Intent addIntent=new Intent(AddPassengers.this,NewPassengers.class);
                int addrequestCode=0x102;
                startActivityForResult(addIntent,addrequestCode);
           }
       });
        new Thread(){
            public void run(){
                URL url= null;
                try {
                    url = new URL(CONSTANT.HOST+"/otn/TicketPassengerList");
                    HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");//设置请求方法
                    SharedPreferences preferences=AddPassengers.this.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                    connection.setRequestProperty("cookie",preferences.getString("cookie",""));
                    connection.setConnectTimeout(CONSTANT.REQUEST_TIMEOUT);//设置连接超时
                    connection.setReadTimeout(CONSTANT.SO_TIMEOUT);//设置读取超时
                    //设置允许输入输出
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    //获取httpUrlConnection的输出流
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
                        passengerList= (ArrayList) orginJson(sb.toString());
                    }else {
                        System.out.println("服务器返回的信息出错："+connection.getResponseCode());
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                PassengerAdapter adapter=new PassengerAdapter(AddPassengers.this,passengerList,result);
                passengers.setAdapter(adapter);
            }
        }.start();
    }
    public List<Passenger> orginJson(String json) {//JSON解析
        List<Passenger> list = new ArrayList<Passenger>();
        Passenger passenger;
        JSONArray object = null;
        try {
            object = new JSONArray(json);
            for (int i = 0; i < object.length(); i++) {
                JSONObject jsonObject = (JSONObject) object.getJSONObject(i);
                passenger=new Passenger(jsonObject.getString("id"),jsonObject.getString("name"),jsonObject.getString("idType"),jsonObject.getString("tel"),
                        jsonObject.getString("type"));
                list.add(passenger);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
    }
