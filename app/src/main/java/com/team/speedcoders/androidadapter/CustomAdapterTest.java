package com.team.speedcoders.androidadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class CustomAdapterTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter_test);

        ((ListView)findViewById(R.id.custom_list)).setAdapter(new MyAdapter(getApplicationContext()));
    }
}
