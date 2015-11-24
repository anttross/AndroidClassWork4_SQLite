package com.jce.ant.classwork4_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.Time;

import com.jce.ant.classwork4_sqlite.DBHelper;

import java.util.ArrayList;

/**
 * Created by Ant on 17-Nov-15.
 */
public class DAL {
    DBHelper dbHelper;



    // do something

    public DAL(Context c){
        dbHelper = new DBHelper(c);

    }

    public void addTimeEntry(String time){
        //get db
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //set data
        ContentValues values = new ContentValues();
        values.put(TimeContract.TimeEntry.TIME, time);

        //insert data
        db.insert(TimeContract.TimeEntry.TABLE_NAME, null, values);

        db.close();
    }

   public Cursor getAllTimeEntriesCursor(){
       SQLiteDatabase db = dbHelper.getReadableDatabase();
       Cursor crs = db.rawQuery("SELECT * FROM "+ TimeContract.TimeEntry.TABLE_NAME, null);

       return crs;
    }

    public ArrayList getAllTimeEntriesList(){
        ArrayList list = new ArrayList();
        Cursor crs = getAllTimeEntriesCursor();
        int timeIndex = crs.getColumnIndex(TimeContract.TimeEntry.TIME);
        while(crs.moveToNext()){
            String enterTime = crs.getString(timeIndex);
            list.add(enterTime);
        }


        return list;
    }


}
