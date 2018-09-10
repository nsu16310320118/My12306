package com.example.aurora.t12306;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLENAME="passager";
    public static final String CREATE_PSGS="create table "+TABLENAME+
            "(_id integer primary key autoincrement,"+"name text,"+
            "type text,"+"cardNo char(18))";

    private Context context;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_PSGS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
        onCreate(sqLiteDatabase);
    }
}
