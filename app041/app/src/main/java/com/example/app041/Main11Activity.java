package com.example.app041;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main11Activity extends AppCompatActivity {
    Button raw_read, sd_read, sd_write, sd_dir_mk, sd_dir_del, sd_list;
    EditText raw_data, raw_data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        raw_read = findViewById(R.id.raw_read);
        raw_data = findViewById(R.id.raw_data);
        raw_data2 = findViewById(R.id.raw_data2);
        sd_read = findViewById(R.id.sd_read);
        sd_write = findViewById(R.id.sd_write);
        sd_dir_mk = findViewById(R.id.sd_dir_mk);
        sd_dir_del = findViewById(R.id.sd_dir_del);
        sd_list = findViewById(R.id.sd_list);
        //permission획득!!
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        //res.raw.raw_test.txt에서 읽어들여!!

        raw_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getResources().openRawResource(R.raw.raw_test);
                    byte[] txt = new byte[inputStream.available()];
                    inputStream.read(txt);
                    raw_data.setText(new String(txt));
                    inputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Log.d("raw_read", "file not found");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("raw_read", "file read error");
                }
            }
        });

        sd_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = new FileInputStream("/sdcard/out.txt");
                    byte[] txt = new byte[inputStream.available()];
                    inputStream.read(txt);
                    raw_data2.setText(new String(txt));
                    inputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Log.d ("sd_read", "file not found");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d ("sd_read", "file read error");
                }

            }
        });

        sd_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream fileOutputStream = null;

                try {
                    fileOutputStream = new FileOutputStream("/sdcard/out.txt");
                    String str="i wan home";
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.close();
                    print("out.txt make");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Log.d("sd_write", "file not found");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("sd_write", "file read error");
                }
            }
        });

        final String strSDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        final File myDir = new File(strSDPath + "/mydir");

        sd_dir_mk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.mkdir();
            }
        });

        sd_dir_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.delete();
            }
        });
    }
        public void print(String result) {
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
        }
}
