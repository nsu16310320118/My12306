package com.example.administrator.my12306;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.administrator.my12306.PassagerInfo;

import java.util.ArrayList;
import java.util.List;

public class PassagerEntity {


    private com.example.aurora.t12306.MyDatabaseHelper helper;

    public PassagerEntity(Context context) {
        helper = new com.example.aurora.t12306.MyDatabaseHelper(context);
    }

    public void add(String name, String type, String cardNo) {
        SQLiteDatabase db = helper.getWritableDatabase();
//        db.execSQL("insert into info(name,type,cardNo),values(?,?,?)", new Object[]{name, type, cardNo});
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("type",type);
        values.put("cardNo",cardNo);
        long result=db.insert("info",null,values);
        db.close();
    }

    public void delete(String name, String type, String cardNo) {
        SQLiteDatabase db = helper.getWritableDatabase();
//        db.execSQL("delete from info where name=?", new Object[]{name});
        int result=db.delete("info","name="+name,new String[]{name});
        db.close();
    }

    //    public void update (String name,String type ,String cardNo){
//        SQLiteDatabase db=helper.getWritableDatabase();
//        db.execSQL("update info(name,type,cardNo),values(?,?,?)",new Object[]{name,type,cardNo});
//    }
    public String find(String name, String type, String cardNo) {
        String str = null;
        SQLiteDatabase db = helper.getReadableDatabase();
        //Cursor cursor = db.rawQuery("select type from info where name=?", new String[]{name});
        Cursor cursor=db.query("info",new String[]{"name"},"name="+name,new String[]{name},null,null,null);
        if (cursor.moveToNext()) {
            str = cursor.getString(0);
        }
        cursor.close();
        db.close();
        return str;
    }

    public List<PassagerInfo> findAll(){
        List<PassagerInfo> passagerInfos=new ArrayList<PassagerInfo>();
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor=db.query("info",null,null, null, null, null, null);
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String type=cursor.getString(2);
            String cardNo=cursor.getString(3);
            PassagerInfo info=new PassagerInfo();
            info.setId(id);
            info.setName(name);
            info.setType(type);
            info.setCardNo(cardNo);
            passagerInfos.add(info);
            info=null;
        }
        return passagerInfos;
    }

}
