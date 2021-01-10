package com.example.app06;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    GridView gridView;
    Integer[] posterId = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
            R.drawable.mov10};
    int[] like = new int[posterId.length];
    String[] title = {"써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자", "아일랜드", "웰컴투동막골", "헬보이", "백투더퓨터"};
    MyGridAdapter myGridAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        gridView = findViewById(R.id.gridView1);

        myGridAdapter = new MyGridAdapter(this);

        gridView.setAdapter(myGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder aBuilder = new AlertDialog.Builder(Main2Activity.this);
                aBuilder.setTitle("영화 상세 내용");
                View dialogView = View.inflate(Main2Activity.this, R.layout.dialog, null);
                ImageView image = findViewById(R.id.image);
                image.setImageResource(posterId[i]);
                final int position = i;
                final EditText score = dialogView.findViewById((R.id.score));
                Button button2 = dialogView.findViewById(R.id.button2);
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        like[position] = like[position] + Integer.parseInt(score.getText().toString());
                        myGridAdapter.notifyDataSetChanged();
                    }
                });
                aBuilder.setIcon(R.drawable.ic_launcher_foreground);
                aBuilder.setNegativeButton("닫기",null);
                aBuilder.show();
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                startActivity(intent);
            }
        });
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;
        public MyGridAdapter(Context context) {
            this.context = context;
        }
        @Override
        public int getCount() {
            return posterId.length  ;
        }

        @Override
        public Object getItem(int i) {
            return posterId[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View dialogView = View.inflate(getApplicationContext(), R.layout.one, null);
            TextView text2 = dialogView.findViewById(R.id.text2);
            text2.setText("영화제목");
            text2.setTextSize(100);
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(0, 15, 5, 15);
            imageView.setImageResource(posterId[i]);

//            imageView.setOnClickListener(new View.OnClickListener(){
//
//                @Override
//                public void onClick(View view) {
//                    AlertDialog.Builder aBuilder = new AlertDialog.Builder(Main2Activity.this);
//                    aBuilder.setTitle("영화 상세 내용");
//                    View dialogView = View.inflate(Main2Activity.this, R.layout.dialog, null);
//                    ImageView image = findViewById(R.id.image);
//                    image.setImageResource(posterId[i]);
//                    aBuilder.setIcon(R.drawable.ic_launcher);
//                    aBuilder.setNegativeButton("닫기",null);
//                    aBuilder.show();
//                }
//            });

            return imageView;
        }
    }
}
