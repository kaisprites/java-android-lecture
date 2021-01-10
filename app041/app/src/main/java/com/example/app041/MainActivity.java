package com.example.app041;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    Button start, end, calButton, timeButton, nextButton;
    CalendarView calendarView;
    TimePicker timePicker;
    int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.ch);
        start = findViewById(R.id.start);
        end = findViewById(R.id.end);
        calButton = findViewById(R.id.calbutton);
        timeButton = findViewById(R.id.timebutton);
        nextButton = findViewById(R.id.nextbutton);
        calendarView = findViewById(R.id.cal);
        timePicker = findViewById(R.id.timer);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                Log.d("Chronometer", "started");
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);
                Log.d("Chronometer", "ended");
                Toast.makeText(getApplicationContext(), chronometer.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), chronometer.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Log.d("date", i + ". " + i1 + ". " + i2 + ". ");
                year = i;
                month = i1;
                day = i2;
            }
        });
        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(year != 0) {
                    Toast.makeText(getApplicationContext(), year + ". " + month + ". " + day + ". ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "날짜를 선택하시오", Toast.LENGTH_SHORT).show();
                }
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
