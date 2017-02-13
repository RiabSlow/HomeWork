package com.team.speedcoders.androidadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Sakkar on 2/12/2017.
 */

class MyAdapter extends ArrayAdapter {
    public MyAdapter(Context context) {
        super(context,R.layout.list_view);
    }

    @Override
    public int getCount() {
        return ListOfName.name.length;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.list_view,parent,false);
        ((TextView)v.findViewById(R.id.name)).setText(ListOfName.name[position]);
        ((TextView)v.findViewById(R.id.row_age)).setText(""+ListOfName.age[position]);
        return v;
    }
}
