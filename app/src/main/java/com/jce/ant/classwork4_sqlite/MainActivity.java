package com.jce.ant.classwork4_sqlite;

import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DAL dalObj = new DAL(this);
        Time now = new Time();
        now.setToNow();
        String time = now.toString();
        dalObj.addTimeEntry(time);

        ArrayList list = new ArrayList();
        list = dalObj.getAllTimeEntriesList();

        for(int i =0;i<list.size();i++){
            Log.e("MainBLa", String.valueOf(list.get(i)));
        }

    }






}


