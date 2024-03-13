package com.example.pr4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataStore extends SQLiteOpenHelper {

    DataStore(Context context){
        super(context,"Pr4",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String s1="create table Register (Name text, Email text, Dob text, Phone_no text, Address text, Password text )";

        db.execSQL(s1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public boolean addData(String n1, String n2, String n3,String n4, String n5, String n6){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("Name",n1);
        cv.put("Email",n2);
        cv.put("Dob",n3);
        cv.put("Phone_no",n4);
        cv.put("Address",n5);
        cv.put("Password",n6);

        int i=(int)db.insert("Register",null,cv);
        if(i>0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean login(String n1,String n2){
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.query("Register",new String[]{"Name","Password"},"Name=? and Password=?",
                new String[]{n1,n2},null,null,null);

        if (c.moveToFirst()){
            return true;
        }
        else {
            return  false;
        }
    }
}
