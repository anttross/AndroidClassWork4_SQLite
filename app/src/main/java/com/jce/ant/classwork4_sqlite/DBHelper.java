package com.jce.ant.classwork4_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ant on 17-Nov-15.
 */
public class DBHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME ="times.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE "+TimeContract.TimeEntry.TABLE_NAME+" ( "+
                        TimeContract.TimeEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        TimeContract.TimeEntry.TIME+" TEXT"+
                        ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TimeContract.TimeEntry.TABLE_NAME);
        onCreate(db);
    }
}
