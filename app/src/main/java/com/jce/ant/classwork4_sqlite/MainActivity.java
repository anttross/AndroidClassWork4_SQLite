package com.jce.ant.classwork4_sqlite;

import android.database.Cursor;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter arrayAdapter;
    SimpleCursorAdapter cursorAdapter;
   // ListView listView;
    Cursor cursor;

    ListView cursorView;
    ListView arrayView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        cursorView = (ListView) findViewById(R.id.CursorListViewLeft);
        arrayView = (ListView) findViewById(R.id.ArraylistViewrRight);

        DAL dalObj = new DAL(this);
        Time now = new Time(); //
        now.setToNow();
        String time = now.toString();
        dalObj.addTimeEntry(time);

        ArrayList list = new ArrayList();
        list = dalObj.getAllTimeEntriesList();

        for(int i =0;i<list.size();i++){
            Log.e("MainBLa", String.valueOf(list.get(i)));
        }


        // begin Cursor Adapter
        String[] colums = new String[] {
                TimeContract.TimeEntry.TIME
        };

        int[] viewsID = new int[]{
                android.R.id.text1
        };

        cursor = dalObj.getAllTimeEntriesCursor();
        cursorAdapter = new SimpleCursorAdapter( this,
                android.R.layout.simple_list_item_1,
                cursor,
                colums,
                viewsID,
                0);


        cursorView.setAdapter(cursorAdapter);

        // end Cursor Adapter


        // begin Array Adapter

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        arrayView.setAdapter(arrayAdapter);

        // end Array Adapter



        arrayView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // String msg = );
                Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });



    }






}


