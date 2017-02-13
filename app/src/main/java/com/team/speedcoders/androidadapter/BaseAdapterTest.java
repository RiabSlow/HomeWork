package com.team.speedcoders.androidadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class BaseAdapterTest extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_test);
        listView= (ListView) findViewById(R.id.baseadaptetlist);

        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return ListOfName.name.length;
            }

            @Override
            public Object getItem(int position) {
                return ListOfName.name[position];
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView v= (TextView) getLayoutInflater().inflate(android.R.layout.simple_list_item_1,parent,false);
                v.setText((String)getItem(position));
                return v;
            }
        });
    }
}
