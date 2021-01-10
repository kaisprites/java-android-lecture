package com.example.app03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button, button2;
    EditText edit1, edit2;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("계산기");

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        edit1 = findViewById(R.id.editText);
        edit2 = findViewById(R.id.editText2);
        textResult = findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "토ㅡ스트", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("다이얼로그");
                //dlg.setMessage("내용");
                dlg.setIcon(R.mipmap.ic_launcher);
                final String[] array = {"오레오", "파이", "큐"};
                dlg.setItems(array, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String uri = "https://www.google.com/search?q=" + array[i];
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                                startActivity(intent);
                            }
                        });
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = edit1.getText().toString();
                String num2 = edit2.getText().toString();
                int result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText(result + "");
                Log.d("", result+"");
            }
        });
    }
}
