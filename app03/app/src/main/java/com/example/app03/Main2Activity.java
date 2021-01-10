package com.example.app03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    ImageView img;
    Button b;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        img = findViewById(R.id.imageView2);
        b = findViewById(R.id.button);

        i = 0;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i%2 == 0) img.setImageResource(R.mipmap.ic_launcher);
                else img.setImageResource(R.mipmap.clas);
                i++;
                }
            }
        });
    }
}
