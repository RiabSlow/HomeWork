package com.team.speedcoders.databasehomework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

class MyController {
    private Context context;

    MyController(Context context) {
        this.context = context;
    }

    boolean insertComment(String comment) {
        try {
            MyDataBaseHelper myDataBaseHelper = new MyDataBaseHelper(context);
            SQLiteDatabase database = myDataBaseHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("comment", comment);
            database.insert("comments", null, values);
            database.close();
            myDataBaseHelper.close();
        } catch (Exception e) {
            Log.w("Exc", "Exception in insertion");
            return false;
        }
        return true;
    }

    ArrayList<String> showComment() {
        ArrayList<String> data =new ArrayList<>();
        try {
            MyDataBaseHelper myDataBaseHelper = new MyDataBaseHelper(context);
            SQLiteDatabase database = myDataBaseHelper.getReadableDatabase();
            Cursor cursor = database.query("comments", new String[]{"cid", "comment"}, null, null, null, null, null);
            if (cursor.moveToFirst())
                do {
                    data.add(""+cursor.getInt(0) + " : " + cursor.getString(1) +"");
                } while (cursor.moveToNext());
            cursor.close();
            database.close();
            myDataBaseHelper.close();
        } catch (Exception e) {
            Log.w("Exc", "Exception in Retrieving data");
            data.clear();
            data.add("Error");
        }
        return data;
    }

    boolean delet(int id) {
        try {
            MyDataBaseHelper myDataBaseHelper = new MyDataBaseHelper(context);
            SQLiteDatabase database = myDataBaseHelper.getReadableDatabase();
            database.delete("comments", "cid=?", new String[]{"" + id});
            database.close();
            myDataBaseHelper.close();
        } catch (Exception e) {
            Log.w("Exc", "Exception in Retrieving data");
            return false;
        }
        return true;
    }
}
