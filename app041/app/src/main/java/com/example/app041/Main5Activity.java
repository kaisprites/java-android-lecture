package com.example.app041;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.ActionBar;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Calendar;

public class Main5Activity extends AppCompatActivity {
    static int syear;
    static int smonth;
    static int sday;
    static String sWeekdayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    public void onClickShowAlert(View view) {
        print(view);
    }

    public void onClickShowDate(View view) {
        showDatePicker(view);
    }

    public void onClickLogPrint(View view) {
        Log.d("나를 부른 view에 대한 정보", "aa");
    }

    public void onClickCheckWeekday(View view) {
        Button btn = (Button)view;
        Log.d("이 버튼의 id", btn.getId() + "");
        Log.d("이 버튼의 텍스트", btn.getText() + "");
        btn.setText("오늘은 월요일입니다.");
    }

    public void print(View view) {
        Log.d("메서드","경고창을띄우는버튼");
    }

    public void showDatePicker(View view) {
        DialogFragment dialogFragment = new DatePickerFragment();
        dialogFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void result (int year, int month, int day ){
        syear = year;
        smonth = month+1;
        sday = day;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("날짜클릭");
        String dateMessage = syear + "년 " + smonth + "월 " + sday + "일";
        builder.setMessage(dateMessage);
        builder.setPositiveButton("전달받은 값 확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), syear + "년 " + smonth + "월 " + sday + "일", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();

        //요일구하기
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        int dayNum = cal.get(Calendar.DAY_OF_WEEK);
        sWeekdayText = "무슨요일";
        switch(dayNum) {
            case 1: sWeekdayText = "일요일"; break;
            case 2: sWeekdayText = "월요일"; break;
            case 3: sWeekdayText = "화요일"; break;
            case 4: sWeekdayText = "수요일"; break;
            case 5: sWeekdayText = "목요일"; break;
            case 6: sWeekdayText = "금요일"; break;
            case 7: sWeekdayText = "토요일"; break;
        }

        //버튼 만들어 붙이기
        Button button = new Button(getApplicationContext());
        button.setText(dateMessage);
        button.setWidth(ActionBar.LayoutParams.MATCH_PARENT);
        button.setHeight(90);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), sWeekdayText + "", Toast.LENGTH_SHORT).show();
            }
        });
        ((LinearLayout)findViewById(R.id.linearlayout)).addView(button);
    }
}
