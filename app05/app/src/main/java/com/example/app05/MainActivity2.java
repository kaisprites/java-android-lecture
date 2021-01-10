package com.example.app05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.ViewFlipper;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("맥락없는 동물그림");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TabHost mainTab = findViewById(R.id.maintab);
        mainTab.setup();

        TabHost.TabSpec tabHome = mainTab.newTabSpec("HOME").setIndicator("홈");
        tabHome.setContent(R.id.tabHome);
        mainTab.addTab(tabHome);

        TabHost.TabSpec tabFav = mainTab.newTabSpec("FAVORITE").setIndicator("즐겨찾기");
        tabFav.setContent(R.id.tabFav);
        mainTab.addTab(tabFav);

        TabHost.TabSpec tabHist = mainTab.newTabSpec("HISTORY").setIndicator("주문내역");
        tabHist.setContent(R.id.tabHist);
        mainTab.addTab(tabHist);

        mainTab.setCurrentTab(0);

        Button btnPrev = findViewById(R.id.button4);
        Button btnNext = findViewById(R.id.button5);
        final ViewFlipper flipper = findViewById(R.id.viewFlipper1);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showPrevious();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });
    }
}
