package com.example.adapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    int[] posterId;
    String[] title;
    int[] like;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        posterId = intent.getIntArrayExtra("poster");
        title = intent.getStringArrayExtra("title");
        like = intent.getIntArrayExtra("like");

        Toast.makeText(getApplicationContext(),posterId.length + " " + title[0] + " " + like[0], Toast.LENGTH_SHORT).show();
        //각 영화마다의 좋아요 득표를 정리해서 보여주세요.!


    }


}
