package com.example.androidcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int appYear, appMonth, appDay;
    TextView txtYearmonth;
    TextView[][] txtDaytxt;
    ArrayList<TextView> scTitleList;
    LinearLayout[][] dayLayout;
    TableRow[] calRow;
    SQLiteDatabase sqlDB;
    DBConnectionHelper dbch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //뷰 찾기
        txtYearmonth = findViewById(R.id.yearmonth);
        dayLayout = new LinearLayout[][] {
                {   findViewById(R.id.dayLayout00), findViewById(R.id.dayLayout01),
                    findViewById(R.id.dayLayout02), findViewById(R.id.dayLayout03),
                    findViewById(R.id.dayLayout04), findViewById(R.id.dayLayout05),
                    findViewById(R.id.dayLayout06)},
                {   findViewById(R.id.dayLayout10), findViewById(R.id.dayLayout11),
                    findViewById(R.id.dayLayout12), findViewById(R.id.dayLayout13),
                    findViewById(R.id.dayLayout14), findViewById(R.id.dayLayout15),
                    findViewById(R.id.dayLayout16)},
                {   findViewById(R.id.dayLayout20), findViewById(R.id.dayLayout21),
                    findViewById(R.id.dayLayout22), findViewById(R.id.dayLayout23),
                    findViewById(R.id.dayLayout24), findViewById(R.id.dayLayout25),
                    findViewById(R.id.dayLayout26)},
                {   findViewById(R.id.dayLayout30), findViewById(R.id.dayLayout31),
                    findViewById(R.id.dayLayout32), findViewById(R.id.dayLayout33),
                    findViewById(R.id.dayLayout34), findViewById(R.id.dayLayout35),
                    findViewById(R.id.dayLayout36)},
                {   findViewById(R.id.dayLayout40), findViewById(R.id.dayLayout41),
                    findViewById(R.id.dayLayout42), findViewById(R.id.dayLayout43),
                    findViewById(R.id.dayLayout44), findViewById(R.id.dayLayout45),
                    findViewById(R.id.dayLayout46)},
                {   findViewById(R.id.dayLayout50), findViewById(R.id.dayLayout51),
                    findViewById(R.id.dayLayout52), findViewById(R.id.dayLayout53),
                    findViewById(R.id.dayLayout54), findViewById(R.id.dayLayout55),
                    findViewById(R.id.dayLayout56)}
        };
        txtDaytxt = new TextView[][] { {findViewById(R.id.dayTxt00), findViewById(R.id.dayTxt01),
                                        findViewById(R.id.dayTxt02), findViewById(R.id.dayTxt03),
                                        findViewById(R.id.dayTxt04), findViewById(R.id.dayTxt05),
                                        findViewById(R.id.dayTxt06)},
                                       {findViewById(R.id.dayTxt10), findViewById(R.id.dayTxt11),
                                        findViewById(R.id.dayTxt12), findViewById(R.id.dayTxt13),
                                        findViewById(R.id.dayTxt14), findViewById(R.id.dayTxt15),
                                        findViewById(R.id.dayTxt16)},
                                       {findViewById(R.id.dayTxt20), findViewById(R.id.dayTxt21),
                                        findViewById(R.id.dayTxt22), findViewById(R.id.dayTxt23),
                                        findViewById(R.id.dayTxt24), findViewById(R.id.dayTxt25),
                                        findViewById(R.id.dayTxt26)},
                                       {findViewById(R.id.dayTxt30), findViewById(R.id.dayTxt31),
                                        findViewById(R.id.dayTxt32), findViewById(R.id.dayTxt33),
                                        findViewById(R.id.dayTxt34), findViewById(R.id.dayTxt35),
                                        findViewById(R.id.dayTxt36)},
                                       {findViewById(R.id.dayTxt40), findViewById(R.id.dayTxt41),
                                        findViewById(R.id.dayTxt42), findViewById(R.id.dayTxt43),
                                        findViewById(R.id.dayTxt44), findViewById(R.id.dayTxt45),
                                        findViewById(R.id.dayTxt46)},
                                       {findViewById(R.id.dayTxt50), findViewById(R.id.dayTxt51),
                                        findViewById(R.id.dayTxt52), findViewById(R.id.dayTxt53),
                                        findViewById(R.id.dayTxt54), findViewById(R.id.dayTxt55),
                                        findViewById(R.id.dayTxt56)}};
        calRow = new TableRow[]{findViewById(R.id.calRow1), findViewById(R.id.calRow2),
                                findViewById(R.id.calRow3), findViewById(R.id.calRow4),
                                findViewById(R.id.calRow5), findViewById(R.id.calRow5)};

        //기타 변수 설정
        dbch = new DBConnectionHelper(this);
        scTitleList = new ArrayList<>();

        //현재날짜 설정
        Calendar cal = Calendar.getInstance();
        appYear = cal.get(Calendar.YEAR);
        appMonth = cal.get(Calendar.MONTH)+1;
        appDay = cal.get(Calendar.DAY_OF_MONTH);
        setDaysTxt();
    }

    //지난달 버튼
    public void getPrevMonth(View view) {
        appMonth -= 1;
        if (appMonth == 0) {
            appMonth = 12;
            appYear--;
        }
        setDaysTxt();
    }

    //다음달 버튼
    public void getNextMonth(View view) {
        appMonth += 1;
        if (appMonth == 13) {
            appMonth = 1;
            appYear++;
        }
        setDaysTxt();
    }

    //달력 내용물 채우기
    public void setDaysTxt() {
        txtYearmonth.setText(appYear + "년 " + appMonth + "월");

        //1일~말일
        Calendar cal1day = Calendar.getInstance();
        cal1day.set(appYear, appMonth-1, 1);
        int firstWeekday = cal1day.get(Calendar.DAY_OF_WEEK);

        int i1 = 0;
        int i2 = firstWeekday-1;
        for(int i=1; i<=cal1day.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            TextView cur = txtDaytxt[i1][i2];
            cur.setText(i + "");
            dayLayout[i1][i2].setOnClickListener(new MyListener<Integer>(i) {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), ScheduleViewer.class);
                    intent.putExtra("appYear", appYear);
                    intent.putExtra("appMonth", appMonth);
                    intent.putExtra("appDay", idx);
                    startActivityForResult(intent, idx);
                }
            });
            switch(i2) {
                case 0: cur.setTextColor(0xFFF44366); break;
                case 6: cur.setTextColor(0xFF3F51B5); break;
                default: cur.setTextColor(0xFF000000); break;
            }
            i2++;
            if(i2 == 7) {
                i1++;
                i2 = 0;
            }
        }

        //다음달1일~ 화면상 보여주는 부분까지
        for(int i=1; ; i++) {
            TextView cur = txtDaytxt[i1][i2];
            cur.setText(i + "");
            dayLayout[i1][i2].setOnClickListener(null);
            switch(i2) {
                case 0: cur.setTextColor(0x80F44366); break;
                case 6: cur.setTextColor(0x803F51B5); break;
                default: cur.setTextColor(0x80000000); break;
            }
            i2++;
            if (i2 == 7) {
                i1++;
                i2 = 0;
            }
            if (i1 == 6) break;
        }

        //지난달화면상 보여주는 부분부터~말일까지
        i1 = 0;
        i2 = firstWeekday-2;
        Calendar calPrevMonth = Calendar.getInstance();
        calPrevMonth.set(Calendar.MONTH, appMonth-1);
        int iday = calPrevMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
        while (i2 != -1) {
            TextView cur = txtDaytxt[i1][i2];
            cur.setText(iday + "");
            dayLayout[i1][i2].setOnClickListener(null);
            switch(i2) {
                case 0: cur.setTextColor(0x80F44366); break;
                default: cur.setTextColor(0x80000000); break;
            }
            i2--;
            iday--;
        }

        //간략한 스케줄 목록 보여주기 (3글자이상 축약, 3개까지)
        for(TextView txt : scTitleList) {
            LinearLayout a = (LinearLayout)txt.getParent();
            a.removeView(txt);
        }
        scTitleList.clear();

        sqlDB = dbch.getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery(
                "SELECT * FROM SCHEDULE WHERE sc_date LIKE ? || '%' order by sc_date",
                new String[] {new SimpleDateFormat("yyyy-MM").format(cal1day.getTime())}
        );
        while(cursor.moveToNext()) {
            int dayCursor = Integer.parseInt(cursor.getString(1).substring(8,10));
            String title = cursor.getString(3);
            if(title.length() > 3) title = title.substring(0,3) + "...";
            int ii1 = (dayCursor-1)/7;
            int ii2 = (dayCursor-1)%7+(firstWeekday-1);
            if(ii2 >= 7) {
                ii2 -= 7;
                ii1 += 1;
            }
            if(dayLayout[ii1][ii2].getChildCount() > 3) continue;
            TextView txt = new TextView(getApplicationContext());
            txt.setText(title);
            scTitleList.add(txt);
            dayLayout[ii1][ii2].addView(txt);
        }
        Log.d("year-month", appYear + "-" + appMonth);
        Log.d("array size", ""+scTitleList.size());
        cursor.close();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        setDaysTxt();
    }
}
