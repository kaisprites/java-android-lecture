package com.example.myservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button start, stop, tStart, tStop;
    Intent intent, timerIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        tStart = findViewById(R.id.startTimer);
        tStop = findViewById(R.id.stopTimer);
        intent = new Intent(getApplicationContext(), MusicService.class);
        timerIntent = new Intent(getApplicationContext(), TimerService.class);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
                android.util.Log.i("서비스 시작 요청됨>>", "startService()");
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
                android.util.Log.i("서비스 종료 요청됨>>", "stopService()");
            }
        });

        tStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(timerIntent);
                android.util.Log.i("서비스 시작 요청됨>>", "startService()");
            }
        });

        tStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(timerIntent);
                android.util.Log.i("서비스 종료 요청됨>>", "stopService()");
            }
        });
    }
}
