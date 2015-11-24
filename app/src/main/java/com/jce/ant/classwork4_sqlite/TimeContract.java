package com.jce.ant.classwork4_sqlite;

import android.provider.BaseColumns;

/**
 * Created by Ant on 17-Nov-15.
 */
public class TimeContract {

        public TimeContract(){}

        public static  abstract  class TimeEntry implements BaseColumns {
            public  static final  String TABLE_NAME = "timeDB";
            public  static final  String TIME = "time";

        }

}
