package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Article extends AppCompatActivity {

    TextView txtAuthor, txtDate, txtTitle, txtContent;
    Button btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        Intent intent = getIntent();
        String author = intent.getStringExtra("author");
        String date = intent.getStringExtra("date");
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");

        txtAuthor = findViewById(R.id.txtAuthor);
        txtDate = findViewById(R.id.txtDate);
        txtTitle = findViewById(R.id.txtTitle);
        txtContent = findViewById(R.id.txtContent);
        btnList = findViewById(R.id.btnList);

        txtAuthor.setText(author);
        txtDate.setText(date);
        txtTitle.setText(title);
        txtContent.setText(content);

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
