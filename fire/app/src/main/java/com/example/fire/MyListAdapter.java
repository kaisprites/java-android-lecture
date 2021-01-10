package com.example.fire;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    Context context;
    TextView textName, textEmail;
    ArrayList<User> user;

    public MyListAdapter(Context context, ArrayList<User> user) {
        this.context = context;
        this.user = user;
    }

    @Override
    public int getCount() {
        return user.size();
    }

    @Override
    public Object getItem(int i) {
        return user.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View oneView = View.inflate(context, R.layout.one, null);
        textName = oneView.findViewById(R.id.textName);
        textEmail = oneView.findViewById((R.id.textEmail));
        textEmail.setText("email: "+user.get(i).getEmail());
        textName.setText("name: "+user.get(i).getUsername());

        return oneView;
    }
}
