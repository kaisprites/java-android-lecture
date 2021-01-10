package com.example.androidcalendar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScheduleAdder extends AppCompatActivity {
    int appYear, appMonth, appDay, appHour, appMinute;
    int scId;
    TextView txtDate;
    EditText editTitle, editContent;
    Switch switchAlarm;
    TimePicker timePicker;
    DBConnectionHelper dbch;
    SQLiteDatabase sqlDB;
    String mode;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_adder);

        //위젯 검색
        editTitle = findViewById(R.id.editTitle);
        editContent = findViewById(R.id.editContent);
        switchAlarm = findViewById(R.id.switchAlarm);
        timePicker = findViewById(R.id.timerView);
        txtDate = findViewById(R.id.txtDate);

        //현재시각
        Calendar cal = Calendar.getInstance();

        //인텐트 받아옴
        Intent intent = getIntent();
        mode = intent.getStringExtra("mode");

        //년월일
        appYear = intent.getIntExtra("appYear", cal.get(Calendar.YEAR));
        appMonth = intent.getIntExtra("appMonth", cal.get(Calendar.MONTH));
        appDay = intent.getIntExtra("appDay", cal.get(Calendar.DAY_OF_MONTH));
        txtDate.setText(appYear + "년" + appMonth + "월" + appDay + "일");

        if(mode.equals("create")) { //스케줄 추가일 경우 시분은 현재시각에 맞춰서
            appHour = cal.get(Calendar.HOUR);
            appMinute = 0;
            cal.set(appYear, appMonth - 1, appDay, appHour, 0, 0);

            timePicker.setHour(appHour);
            timePicker.setMinute(0);
        } else if (mode.equals ("modify")) { //스케줄 변경일 경우 레코드에서 가져온 그대로 넣어준다
            appHour = intent.getIntExtra("appHour", cal.get(Calendar.HOUR));
            appMinute = intent.getIntExtra("appMinute", cal.get(Calendar.MINUTE));
            scId = intent.getIntExtra("id", 0);
            editTitle.setText(intent.getStringExtra("title"));
            editContent.setText(intent.getStringExtra("content"));
            switchAlarm.setChecked(intent.getBooleanExtra("alarm", false));

            timePicker.setHour(appHour);
            timePicker.setMinute(appMinute);
        }

        //timepicker가 변하는 대로 변수에 반영
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                appHour = i;
                appMinute = i1;
            }
        });

        //스케줄 추가 화면이면 삭제버튼은 감춘다
        if(mode.equals("create")){
            ImageButton btnDelete = findViewById(R.id.btnDelete);
            btnDelete.setVisibility(View.GONE);
        }
    }

    //취소
    public void AdderCancel(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    ///삭제
    public void AdderDelete(View view) {
        dbch = new DBConnectionHelper(this);
        sqlDB = dbch.getWritableDatabase();
        sqlDB.execSQL("DELETE FROM SCHEDULE WHERE ID = ?", new String[]{scId+""});
        sqlDB.close();
        setResult(RESULT_OK);
        finish();
    }

    //추가버튼
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void AdderSubmit(View view){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Calendar cal = Calendar.getInstance();
        cal.set(appYear, appMonth, appDay, appHour, appMinute, 0);

        String scDate = dateFormat.format(cal.getTime());
        String scTime = timeFormat.format(cal.getTime());
        String scTitle = editTitle.getText().toString();
        String scContent = editContent.getText().toString();
        String alarm = switchAlarm.isChecked() ? "1" : "0";

        //제목은 not null
        if (scTitle.equals("")) {
            Toast.makeText(getApplicationContext(), "제목을 입력하시오", Toast.LENGTH_SHORT).show();
            return;
        }
        String[] queryParam = new String[]{scDate, scTime, scTitle, scContent, alarm};

        //DB처리
        dbch = new DBConnectionHelper(this);
        sqlDB = dbch.getWritableDatabase();
        if (mode.equals("create")) {
            sqlDB.execSQL("INSERT INTO SCHEDULE VALUES (null, ?, ?, ?, ?, ?)", queryParam);
        } else if (mode.equals("modify")) {
            sqlDB.execSQL("UPDATE SCHEDULE SET SC_DATE = ?, SC_TIME = ?, " +
                    "SC_TITLE = ?, SC_CONTENT = ?, ALARM = ? WHERE ID = ?",
                    new String[] {scDate, scTime, scTitle, scContent, alarm, String.valueOf(scId)});
        }
        sqlDB.close();

//        // receiver에 string 값 넘겨주기
//        Intent alarmIntent = new Intent(getApplicationContext(), AlarmReceiver.class);
//        alarmIntent.putExtra("state","alarm on");
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),
//                0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//
//        // 알람셋팅
//        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
//
        setResult(RESULT_OK);
        finish();
    }
}
