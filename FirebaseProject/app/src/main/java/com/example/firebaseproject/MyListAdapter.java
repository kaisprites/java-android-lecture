package com.example.firebaseproject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    Context context;
    TextView txtTitle, txtAuthor;
    ArrayList<BBSVO> bbsList;

    public MyListAdapter(Context context, ArrayList<BBSVO> bbsList) {
        this.context = context;
        this.bbsList = bbsList;
    }

    @Override
    public int getCount() {
        return bbsList.size();
    }

    @Override
    public Object getItem(int i) {
        return bbsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View oneView = View.inflate(context, R.layout.listone, null);
        txtTitle = oneView.findViewById(R.id.txtOneTitle);
        txtAuthor = oneView.findViewById(R.id.txtOneAuthor);
        txtTitle.setText(bbsList.get(i).getTitle());
        txtAuthor.setText(bbsList.get(i).getAuthor());
        return oneView;
    }
}
