package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Write extends AppCompatActivity {
    String name;
    EditText editName, editTitle, editContent;
    Button btnSubmit, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        editName = findViewById(R.id.editName);
        editTitle = findViewById(R.id.editTitle);
        editContent = findViewById(R.id.editContent);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        editName.setText(name);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent result = new Intent();
                result.putExtra("title", editTitle.getText().toString());
                result.putExtra("content", editContent.getText().toString());
                setResult(RESULT_OK, result);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
