package com.team.speedcoders.androidadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayAdapterTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_test);
        ArrayAdapter <String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,ListOfName.name);
        ((ListView)findViewById(R.id.array_list)).setAdapter(arrayAdapter);
    }
}
