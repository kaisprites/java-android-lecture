package com.example.app06;

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
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String[] food = {"감자", "고구마", "양파"};

        final ArrayList<String> food = new ArrayList<>();
        food.add("감자");
        food.add("고구마");
        food.add("양파");

        //뷰객체
        listView = findViewById(R.id.listView1);

        //어댑터
        adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, food);

        listView.setAdapter(adapter);
        //
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, food.get(i), Toast.LENGTH_SHORT).show();
            }
        });
        edit = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                food.add(edit.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}
