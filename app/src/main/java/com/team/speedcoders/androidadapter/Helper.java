package com.team.speedcoders.androidadapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sakkar on 2/13/2017.
 */

class Helper extends SQLiteOpenHelper {
    final static int VERSION=8;
    final static String DATABASE_NAME="Students";
    final static String TABLE_NAME="Student";
    final static String NAME_COLUMN="Name";
    final static String AGE_COLUMN="Age";
    final static String QUERY="CREATE TABLE "+TABLE_NAME+
            "(" +
            "_id int primary key,"+
            NAME_COLUMN+ " CHAR[20]," +
            AGE_COLUMN+" int"+
            ");";
    public Helper(Context context) {
        super(context, DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUERY);
        for(int i=0;i<ListOfName.name.length;i++){
            ContentValues contentValues=new ContentValues();
            contentValues.put("_id",i);
            contentValues.put(NAME_COLUMN,ListOfName.name[i]);
            contentValues.put(AGE_COLUMN,ListOfName.age[i]);
            db.insert(TABLE_NAME,null,contentValues);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
