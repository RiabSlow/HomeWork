package com.team.speedcoders.databasehomework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MyDataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="test.db",QUEQRY="CREATE TABLE IF NOT EXISTS comments(" +
            "cid integer primary key autoincrement," +
            "comment text);";
    private static final int VERSION=1;
    public MyDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUEQRY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS comment");
        onCreate(db);
    }
}
