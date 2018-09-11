package com.example.administrator.my12306;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class usually extends AppCompatActivity {
private ListView listView;
private ArrayAdapter myadapter;
private List<Passenger> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usually);
        //从数据库中调取该账号使用过的乘客名单
        listView=findViewById(R.id.listView);
        new Thread(){
            public void run(){
                URL url= null;
                try {
                    url = new URL(CONSTANT.HOST+"/otn/PassengerList");
                    HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");//设置请求方法
                    SharedPreferences preferences=usually.this.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
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
                        list=orginJson(sb.toString());
                    }else {
                        System.out.println("服务器返回的信息出错："+connection.getResponseCode());
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //已取得联系人信息，需要展示
                myadapter=new ArrayAdapter(usually.this, R.layout.passenger_info,list);
                listView.setAdapter(myadapter);
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
