package com.example.administrator.my12306;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Login_Activity extends AppCompatActivity {
    private EditText textUserName, textPassword;
    private TextView forget;
    private Button login, register;
    private CheckBox remember;
    private String userName, passWord;
    private myDatabase myDatabase;
    private SQLiteDatabase db;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    int result = msg.arg1;
                    String sessionId = msg.obj.toString();
                    if (result == 0) {
                        textUserName.setError("用户名或者密码错误");
                        textUserName.requestFocus();
                    } else if (result == 1) {
                        SharedPreferences preferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        if (remember.isChecked()) {
                            editor.putString("username", textUserName.getText()).toString();
                            editor.putString("password", Md5Utils.MD5(textPassword.getText().toString()));

                        }
                        editor.putString("cookie", sessionId);
                        editor.commit();
                        Intent intent = new Intent(Login_Activity.this, MainActivity.class);
                        startActivity(intent);
                        Login_Activity.this.finish();
                    }
                    break;
                case 2:
                    Toast.makeText(Login_Activity.this, "服务器错误，请重试", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        textUserName.setText(data.getStringExtra(""));
        textPassword.setText(data.getStringExtra(""));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        textUserName = findViewById(R.id.editUserName);
        textPassword = findViewById(R.id.editPassword);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        remember = findViewById(R.id.remember);
        forget = findViewById(R.id.forget);
        myDatabase = new myDatabase(this, "UserMessage.db", null, 1);
        db = myDatabase.getReadableDatabase();
        userName = textUserName.getText().toString();
        passWord = textPassword.getText().toString();
        //--------------------------
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Activity.this, forgetPwd_Activity.class);
                if (!TextUtils.isEmpty(userName)) {
                    intent.putExtra("username", userName);
                } else {
                    intent.putExtra("username", "");
                }
                startActivity(intent);
            }
        });//跳转到忘记密码界面

        login.setOnClickListener(new View.OnClickListener() {
                                     boolean isin = false;

                                     //            private String strUserName=textUserName.getText().toString();
//            private String strPassWord=textPassword.getText().toString();
                                     @Override
                                     public void onClick(View view) {
                                         //跳转到主界面
                                         if (TextUtils.isEmpty(userName)) {
                                             textUserName.setError("输入用户名为空");
                                             textUserName.requestFocus();
                                         } else if (TextUtils.isEmpty(passWord)) {
                                             textPassword.setError("输入密码为空");
                                             textPassword.requestFocus();
                                         } else {
//                    Intent intent = new Intent(Login_Activity.this, MainActivity.class);
//                    startActivity(intent);
                                             if (!NetUtils.check(Login_Activity.this)) {
                                                 Toast.makeText(Login_Activity.this, "网络异常，请检查", Toast.LENGTH_LONG).show();
                                                 return;
                                             }
                                             new Thread() {
                                                 @Override
                                                 public void run() {
                                                     Message msg = handler.obtainMessage();
                                                     String result = "";
                                                     try {
                                                         URL url = new URl(CONSTANT.HOST + "/Login");
                                                         HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();//设置请求
                                                         httpURLConnection.setRequestMethod("POST");//设置请求方法
                                                         httpURLConnection.setConnectTimeout(CONSTANT.REQUEST_TIMEOUT);//设置连接超时
                                                         httpURLConnection.setReadTimeout(CONSTANT.SO_TIMEOUT);//设置读取超时
                                                         //设置允许输入输出
                                                         httpURLConnection.setDoInput(true);
                                                         httpURLConnection.setDoOutput(true);
                                                         //获取httpUrlConnection的输出流
                                                         PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
                                                         String params = "username=" + textUsername.getText().toString()
                                                                 + "&password=" + Md5Utils.MD5(textPassword.getText().toString());
                                                         //发送参数
                                                         System.out.println("发往服务器的参数" + params);
                                                         printWriter.write(params);
                                                         printWriter.flush();
                                                         printWriter.close();
                                                         //获取响应状态
                                                         int reponseCode = httpURLConnection.getResponseCode();
                                                         if (reponseCode == HttpURLConnection.HTTP_OK) {
                                                             //打开输入流
                                   /* StringBuilder sb = new StringBuilder();
                                    String line = "";
                                    BufferedReader bufferedReader = new BufferedReader(
                                            new InputStreamReader(httpURLConnection.getInputStream()));
                                    while ((line = bufferedReader.readLine())!=null){
                                        sb.append(line).append("\n");
                                    }
                                    System.out.println("服务器返回的信息："+sb.toString());
                                    bufferedReader.close();*/
                                                             // 进行PULL解析
                                                             //1、生成解析器
                                                             XmlPullParser parser = Xml.newPullParser();
                                                             //2、引入要解析的流
                                                             parser.setInput(new InputStreamReader(httpURLConnection.getInputStream()));
                                                             //3、事件类型解析
                                                             int type = parser.getEventType();
                                                             while (type != XmlPullParser.END_DOCUMENT) {
                                                                 switch (type) {
                                                                     case XmlPullParser.START_TAG:
                                                                         if ("result".equals(parser.getName())) {
                                                                             result = parser.nextText();
                                                                             System.out.println("解析出的服务器响应信息result=" + result);
                                                                         }
                                                                         break;
                                                                 }
                                                                 type = parser.next();
                                                             }
                                                             //获取sessionID
                                                             String header = httpURLConnection.getHeaderField("Set-Cookie");
                                                             System.out.println("获取的头部信息：" + header);
                                                             String[] backHeader = header.split(";");
                                                             String sessionId = backHeader[0];
                                                             System.out.println("获取的sessionId" + sessionId);
                                                             //发送消息
                                                             msg.what = 1;
                                                             msg.arg1 = Integer.parseInt(result);
                                                             msg.obj = sessionId;
                                                         } else {
                                                             //网络状态异常
                                                             msg.what = 2;
                                                         }

                                                     } catch (MalformedURLException e) {
                                                         e.printStackTrace();
                                                         msg.what = 2;
                                                     } catch (IOException e) {
                                                         e.printStackTrace();
                                                         msg.what = 2;
                                                     } catch (XmlPullParserException e) {
                                                         e.printStackTrace();
                                                         msg.what = 2;
                                                     }
                                                     handler.sendMessage(msg);
                                                 }
                                             }.start();

                                         }
                                     }
//                isin=ifitInDB(strUserName,strPassWord);
//                if(isin){
//                    //用户存在于数据库内，跳转到主界面
//                    Intent intent=new Intent(Login_Activity.this,MainActivity.class);
//                    startActivity(intent);
//                }
//                else {
//                    textUserName.setError("账户或密码存在问题，请检查并重新输入");
//                    textUserName.requestFocus();
//                }

                                 }
        );
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Activity.this, Register_Activity.class);
                startActivityForResult(intent, 1);

            }

        });
    }


    public boolean ifitInDB(String strUserName, String strPassWord) {
        boolean flag = false;
        String name = strUserName;
        String password = strPassWord;
        String sql = "Select PassWord from myUser where UserName=?";
        Cursor cursor = db.rawQuery(sql, new String[]{name});
        if (cursor.moveToFirst()) {
            String getpwd = cursor.getString(cursor.getColumnIndex("PassWord"));
            if (getpwd.equals(password)) {
                flag = true;
            }
        }
        return flag;
    }
}
