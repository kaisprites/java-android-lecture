package com.example.apptravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button b1, b2;
    static int i;
    static int[] image = new int[]{R.drawable.bassili, R.drawable.himeji,
                                   R.drawable.neuschwanstein, R.drawable.tajmaha};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.imageView);
        b1 = (Button)findViewById(R.id.button2);
        b2 = (Button)findViewById(R.id.button3);
        i = 0;

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                img.setImageResource(image[i]);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("index",i%4);
                startActivity(intent);
            }
        });
    }
}
