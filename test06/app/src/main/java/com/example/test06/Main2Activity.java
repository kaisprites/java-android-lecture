package com.example.test06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Button button;
    int[] image = {R.raw.cat01, R.raw.cat02, R.raw.cat03, R.raw.cat04, R.raw.cat05};
    String[] title = {"sinful cat", "cat and yoshi", "long cat", "woman yelling at cat", "SCP-040-JP"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        final int i = intent.getIntExtra("i", 0);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        imageView.setImageResource(image[i]);
        textView.setText(title[i]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.google.com/search?q=" + title[i]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
