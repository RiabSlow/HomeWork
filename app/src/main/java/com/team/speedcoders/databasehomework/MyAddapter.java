package com.team.speedcoders.databasehomework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


class MyAddapter extends ArrayAdapter<String> {
    Context context;
    public MyAddapter(Context context, ArrayList objects) {
        super(context, R.layout.list_view_view, objects);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommentClass commentClass;
        View rootView=convertView;
        if(rootView==null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rootView= layoutInflater.inflate(R.layout.list_view_view, parent, false);
            TextView t1= (TextView) rootView.findViewById(R.id.position);
            TextView t2= (TextView) rootView.findViewById(R.id.name);
            commentClass=new CommentClass(t1,t2);
            rootView.setTag(commentClass);
        }
        else{
            commentClass= (CommentClass) rootView.getTag();
        }
        commentClass.getPosition().setText("Row-"+position+" ");
        commentClass.getComment().setText(getItem(position));
        return rootView;
    }
}
