package com.example.androidcalendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class ScheduleAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<ScheduleDTO> list;
    LayoutInflater mLayoutInflater = null;

    public ScheduleAdapter(Context context, ArrayList<ScheduleDTO> list) {
        mContext = context;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ScheduleDTO getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mLayoutInflater.inflate(R.layout.layout_schedule_item, viewGroup, false);

        CheckBox checkBox = v.findViewById(R.id.checkBox);
        TextView txtTime = v.findViewById(R.id.txtTime);
        TextView txtTitle = v.findViewById(R.id.txtTitle);

        checkBox.setChecked(list.get(i).getAlarm());
        txtTime.setText(list.get(i).getTime());
        txtTitle.setText(list.get(i).getTitle());

        return v;
    }
}
