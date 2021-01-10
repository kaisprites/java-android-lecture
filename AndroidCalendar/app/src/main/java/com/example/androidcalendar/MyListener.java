package com.example.androidcalendar;

import android.view.View;

public abstract class MyListener<T> implements View.OnClickListener {
    T idx;
    public MyListener(T idx){
        this.idx = idx;
    }
    @Override
    public abstract void onClick(View view);
}