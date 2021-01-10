package com.example.app041;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //리스트뷰, 리스트뷰 어뎁터 초기화
        listView = findViewById(R.id.listView1);
        listViewAdapter = new ListViewAdapter();

        //어뎁터에 아이템 추가
        listViewAdapter.addItem("첫번째 row아이템1","첫번째 row아이템2");
        listViewAdapter.addItem("두번째 row아이템1","첫번째 row아이템2");
        for(int i = 0 ; i < 3 ; i ++){
            listViewAdapter.addItem(i+"for문 + row아이템1",i+"for문 + row아이템2");
        }

        //리스트뷰에 어뎁터 set
        listView.setAdapter(listViewAdapter);
    }
}
