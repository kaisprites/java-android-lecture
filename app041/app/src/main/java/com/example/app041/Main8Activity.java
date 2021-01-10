package com.example.app041;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.example.app041.Main5Activity;

public class Main8Activity extends AppCompatActivity {
    Button btnRead, btnWrite, open, save;
    EditText editName, editCompany, editEmail, editPhone, query;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        btnRead = findViewById(R.id.readSD);
        btnWrite = findViewById(R.id.writeSD);
        open = findViewById(R.id.loadAddr);
        save = findViewById(R.id.addrWrite);
        editName = findViewById(R.id.editName);
        editCompany = findViewById(R.id.editCompany);
        editEmail = findViewById(R.id.editEmail);
        editPhone = findViewById(R.id.editPhone);
        query = findViewById(R.id.query);
        textView = findViewById(R.id.textView);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fileOutputStream = openFileOutput("out.txt", Context.MODE_PRIVATE);
                    String str = "파일의내용";
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(getApplicationContext(), "파일이 생성됨", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inputStream = openFileInput("out.txt");
                    byte[] txt = new byte[256];
                    inputStream.read(txt);
                    String str = new String(txt);
                    inputStream.close();
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "파일없음", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String name = editName.getText().toString();
                    FileOutputStream outputStream = openFileOutput(name + ".txt", Context.MODE_PRIVATE);

                    String str =  name + "\n"
                            + editCompany.getText().toString() + "\n"
                            + editEmail.getText().toString() + "\n"
                            + editPhone.getText().toString();
                    outputStream.write(str.getBytes());
                    outputStream.close();
                    Toast.makeText(getApplicationContext(), name + ".txt 파일 생성됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String name = query.getText().toString();
                    FileInputStream inputStream = openFileInput(name + ".txt");
                    byte[] txt = new byte[65536];
                    inputStream.read(txt);
                    String str = new String(txt);
                    inputStream.close();
                    textView.setText(str);
                    Toast.makeText(getApplicationContext(), name + ".txt 파일 불러옴", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "파일이 존재하지 않습니다", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
