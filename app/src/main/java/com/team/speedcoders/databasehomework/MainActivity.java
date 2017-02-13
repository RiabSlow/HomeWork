package com.team.speedcoders.databasehomework;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button showComment,submit,delete;
    EditText comment,commentId;
    ListView showCommentArea;
    MyController myController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeAll();
    }

    private void initializeAll() {
        showComment= (Button) findViewById(R.id.commentShow);
        submit= (Button) findViewById(R.id.submitComment);
        delete= (Button) findViewById(R.id.delete);
        delete.setOnClickListener(this);
        showComment.setOnClickListener(this);
        submit.setOnClickListener(this);
        comment= (EditText) findViewById(R.id.comment);
        commentId= (EditText) findViewById(R.id.deleteId);
        showCommentArea= (ListView) findViewById(R.id.comment_display_area);
    }

    @Override
    public void onClick(View v) {
        myController=new MyController(getApplicationContext());
        switch (v.getId()){
            case R.id.submitComment:
                if(!myController.insertComment(comment.getText().toString()))
                    Toast.makeText(getApplicationContext(),"Error occurred",Toast.LENGTH_SHORT).show();
                break;
            case R.id.commentShow:
                showCommentArea.setAdapter(new MyAddapter(getApplicationContext(),myController.showComment()));
                break;
            case R.id.delete:
                if(!myController.delet(Integer.parseInt(commentId.getText().toString())))
                    Toast.makeText(getApplicationContext(),"Error occurred",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
