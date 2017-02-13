package com.team.speedcoders.databasehomework;


import android.widget.TextView;

class CommentClass {
    private TextView position,comment;

    public CommentClass(TextView comment, TextView position) {
        this.comment = comment;
        this.position = position;
    }

    public TextView getComment() {
        return comment;
    }

    public TextView getPosition() {
        return position;
    }
}
