package com.bcb.user.bareillycollegebareilly;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqldatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="bareillycollege.dp";
    public static final String TABLE_NAME="course_table";
    public static final String ID="ID";
    public static final String COL_1="MAIN_TITLE";
    public static final String COL_2="SUB_TITLE";
    public static final String COL_3="IMAGE_TITLE";

    public Sqldatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " +TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,MAIN_TITLE TEXT,SUB_TITLE TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

//    public boolean insertData(String main_title,String sub_title)
//    {
//        SQLiteDatabase db =this.getWritableDatabase();
//
//    };
    public Cursor getAllData(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +TABLE_NAME,null);
        return res;
    }
}
