package com.example.apptravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    ImageView imageview;
    TextView textview;
    Button button;
    static int i;
    static int[] image = new int[]{R.drawable.bassili, R.drawable.himeji,
                                   R.drawable.neuschwanstein, R.drawable.tajmaha};
    static String[] name = new String[]{"바실리 성당", "히메지 성", "노이슈반슈타인", "타지마할"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        i = getIntent().getIntExtra("index", 0);

        imageview = findViewById(R.id.imageView4);
        textview = findViewById(R.id.textView4);
        button = findViewById(R.id.button);

        imageview.setImageResource(image[i]);
        textview.setText(name[i]);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "https://www.google.com/search?q=" + name[i];
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
    }
}
