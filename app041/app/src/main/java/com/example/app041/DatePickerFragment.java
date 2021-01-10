package com.example.app041;

import android.app.DatePickerDialog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Calendar;


public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        Log.d("달력 다이얼로그 생성", year + "년 " + (month+1) + "월 " + day + "일 ");
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        logPrint(i, i1, i2);
        Main5Activity activity5 = (Main5Activity)getActivity();
        activity5.result(i, i1, i2);
    }

    public void logPrint(int year, int month, int date) {
        Log.d("선택한 날짜는 ", year + "년 " + (month+1) + "월 " + date + "일 ");
    }
}
