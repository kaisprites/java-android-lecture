package com.example.app041;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBConnectionHelper extends SQLiteOpenHelper {
    private static String DB_PATH = "/data/data/com.example.app041/databases";
    private static String DB_NAME = "app041db";

    public DBConnectionHelper(Context context) {
        super(context, "megadb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table groupTBL (gName char(20) primary key, gNumber integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table groupTBL");
    }
}
