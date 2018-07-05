package com.example.administrator.my12306;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class myDatabase extends SQLiteOpenHelper {
    private String Createdb;
    private Context myContext;

    public myDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        myContext=context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    Createdb="create table UserMessage("+
            "id integer primary key autoincrement,UserName varchar(20),PassWord varchar(20),Name varchar(20),IDNumber varchar(20),phoneNumber varchar(15));";
            sqLiteDatabase.execSQL(Createdb);
        Toast.makeText(myContext,"Create succeed",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
