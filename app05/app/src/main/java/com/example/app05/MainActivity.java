package com.example.app05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabSpec1.setContent(R.id.tab1);
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("ARTIST").setIndicator("가수별");
        tabSpec2.setContent(R.id.tab2);
        tabHost.addTab(tabSpec2);

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("ALBUM").setIndicator("앨범별");
        tabSpec3.setContent(R.id.tab3);
        tabHost.addTab(tabSpec3);

        tabHost.setCurrentTab(0);

        Button btnPrev, btnNext;
        final ViewFlipper viewFlipper;

        btnPrev = (Button)findViewById(R.id.btnPrev);
        btnNext = (Button)findViewById(R.id.btnNext);
        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper1);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.showPrevious();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.showNext();
            }
        });
    }
}
