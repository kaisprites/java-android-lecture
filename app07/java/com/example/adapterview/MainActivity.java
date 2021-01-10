package com.example.adapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText edit;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //액티비티를 초기화하면서 객체생성

        //1. 데이터 준비(array, arraylist준비)
        //final String[] food = {"감자", "고구마", "양파"};
        final ArrayList<String> food = new ArrayList<>();
        food.add("감자");
        food.add("고구마");
        food.add("양파");

        //2. view객체를 준비
        listView = findViewById(R.id.listView1);

        //3. adapter준비
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, food);

        //4. view에 adapter지정/설정
        listView.setAdapter(adapter);

        //5. 하나의 item마다 어떻게 처리할지 이벤트 지정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), food.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        edit = findViewById(R.id.edit);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //arraylist에 추가를 해야함.
                food.add(edit.getText().toString());
                //adapter에게 데이터의 변경이 있음을 알려주어야함.
                adapter.notifyDataSetChanged();
            }
        });

    }
}
