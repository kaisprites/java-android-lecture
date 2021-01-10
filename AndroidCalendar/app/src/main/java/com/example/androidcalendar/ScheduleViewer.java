package com.example.androidcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class ScheduleViewer extends AppCompatActivity {
    int appYear, appMonth, appDay;
    String strDate;
    ArrayList<ScheduleDTO> scArray;
    TextView txtDate;
    SQLiteDatabase sqlDB;
    DBConnectionHelper dbch;
    ListView listview;
    ScheduleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_viewer);

        txtDate = findViewById(R.id.txtDate);
        listview = findViewById(R.id.listview);

        Calendar cal = Calendar.getInstance();
        Intent intent = getIntent();
        appYear = intent.getIntExtra("appYear", cal.get(Calendar.YEAR));
        appMonth = intent.getIntExtra("appMonth", cal.get(Calendar.MONTH));
        appDay = intent.getIntExtra("appDay", cal.get(Calendar.DAY_OF_MONTH));
        cal.set(appYear, appMonth-1, appDay);

        txtDate.setText(appYear + "년 " + appMonth + "월 " + appDay + "일 ");

        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        strDate = dateformat.format(cal.getTime());

        getScheduleList();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), i+"", Toast.LENGTH_SHORT).show();
                ScheduleDTO dto = adapter.getItem(i);

                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date date;
                try {
                    date = format.parse(dto.getDate() + " " + dto.getTime());
                } catch (ParseException e) {
                    date = new Date();
                }

                Calendar cal = Calendar.getInstance();
                cal.setTime(date);

                Intent intent = new Intent(getApplicationContext(), ScheduleAdder.class);
                intent.putExtra("appYear", cal.get(Calendar.YEAR));
                intent.putExtra("appMonth", cal.get(Calendar.MONTH));
                intent.putExtra("appDay", cal.get(Calendar.DAY_OF_MONTH));
                intent.putExtra("appHour", cal.get(Calendar.HOUR));
                intent.putExtra("appMinute", cal.get(Calendar.MINUTE));
                intent.putExtra("id", dto.getId());
                intent.putExtra("title", dto.getTitle());
                intent.putExtra("content", dto.getContent());
                intent.putExtra("alarm", dto.getAlarm());
                intent.putExtra("mode", "modify");
                startActivityForResult(intent, 1);
            }
        });

    }

    public void getScheduleList() {
        scArray = new ArrayList<>();
        dbch = new DBConnectionHelper(this);
        sqlDB = dbch.getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery(
                "SELECT * FROM SCHEDULE where sc_date = ? ORDER BY sc_time, sc_title",
                new String[] {strDate});
        while(cursor.moveToNext()) {
            ScheduleDTO dto = new ScheduleDTO();
            dto.setId(cursor.getInt(0));
            dto.setDate(cursor.getString(1));
            dto.setTime(cursor.getString(2));
            dto.setTitle(cursor.getString(3));
            dto.setContent(cursor.getString(4));
            dto.setAlarm(cursor.getInt(5) == 1);
            Log.d("cursor", cursor.toString());
            Log.d("dto", dto.toString());
            scArray.add(dto);
        }
        cursor.close();
        sqlDB.close();
        adapter = new ScheduleAdapter(getApplicationContext(), scArray);
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void ScheduleViewCancel(View view){
        setResult(RESULT_OK);
        finish();
    }

    public void CreateSchedule(View view){
        Calendar cal = Calendar.getInstance();
        Intent intent = new Intent(getApplicationContext(), ScheduleAdder.class);
        intent.putExtra("appYear", appYear);
        intent.putExtra("appMonth", appMonth-1);
        intent.putExtra("appDay", appDay);
        intent.putExtra("mode", "create");
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getScheduleList();
    }
}
