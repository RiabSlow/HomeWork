package com.team.speedcoders.androidadapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CursorAdapterTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursor_adapter);
        Helper helper=new Helper(getApplicationContext());
        SQLiteDatabase sqLiteDatabase=helper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("Select * from Student",null);
        ((ListView)findViewById(R.id.cursorList)).setAdapter(new CursorAdapter(getApplicationContext(),cursor,0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return getLayoutInflater().inflate(R.layout.list_view,parent,false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView textView1= (TextView) view.findViewById(R.id.name);
                TextView textView2= (TextView) view.findViewById(R.id.row_age);

                textView1.setText(cursor.getString(cursor.getColumnIndexOrThrow(Helper.NAME_COLUMN)));
                textView2.setText(""+cursor.getString(cursor.getColumnIndexOrThrow(Helper.AGE_COLUMN)));
            }
        });

    }
}
