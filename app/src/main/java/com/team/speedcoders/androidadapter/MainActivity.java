package com.team.speedcoders.androidadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.button1)).setOnClickListener(this);
        ((Button)findViewById(R.id.button2)).setOnClickListener(this);
        ((Button)findViewById(R.id.button3)).setOnClickListener(this);
        ((Button)findViewById(R.id.button4)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.button1:
                i=new Intent(this,BaseAdapterTest.class);
                startActivity(i);
                break;
            case R.id.button2:
                i=new Intent(this,ArrayAdapterTest.class);
                startActivity(i);
                break;
            case R.id.button3:
                i=new Intent(this,CustomAdapterTest.class);
                startActivity(i);
                break;
            case R.id.button4:
                i=new Intent(this,CursorAdapterTest.class);
                startActivity(i);
                break;
        }
    }
}
