package com.example.firebaseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    DatabaseReference bbs;
    ArrayList<BBSVO> bbsList;
    int i = 1;
    MyListAdapter adapter;
    TextView textView;
    Button btnLogin, btnWrite;
    ListView listView;
    String loggedinName = "Guest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtId);
        btnLogin = findViewById(R.id.btnLogin);
        btnWrite = findViewById(R.id.btnWrite);
        listView = findViewById(R.id.listView);
        bbsList = new ArrayList<>();
        bbs = FirebaseDatabase.getInstance().getReference("/project/bbs");
        Log.d("firebase", bbs + "");

        //게시물 목록 읽어오기
        bbs.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                bbsList.clear();
                for(DataSnapshot s: snapshot.getChildren()){
                    int num = Integer.parseInt(s.getKey());
                    i = Math.max(i, num);
                    BBSVO vo = s.getValue(BBSVO.class);
                    vo.setNum(num);
                    bbsList.add(0, vo);
                }
                Log.d("firebase", bbsList.toString());
                adapter = new MyListAdapter(getApplicationContext(), bbsList);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent oneItem = new Intent(getApplicationContext(), Article.class);
                        oneItem.putExtra("title", bbsList.get(i).getTitle());
                        oneItem.putExtra("content", bbsList.get(i).getContent());
                        oneItem.putExtra("date", bbsList.get(i).getDate());
                        oneItem.putExtra("author", bbsList.get(i).getAuthor());
                        startActivity(oneItem);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //로그인
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivityForResult(intent, 0);
            }
        });

        //글쓰기
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Write.class);
                intent.putExtra("name", loggedinName);
                startActivityForResult(intent, 1);
            }
        });
    }

    //액티비티에서 받아온 결과 처리
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String title = data.getStringExtra("title");
                String content = data.getStringExtra("content");
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                BBSVO vo = new BBSVO(loggedinName, content, date, title);
                i++;
                writeNewArticle(i + "", vo);
            }
        } else if (requestCode == 0) {
            if(resultCode == RESULT_OK) {
                String id = data.getStringExtra("id");
                loggedinName = id;
                textView.setText(id);
            }
        }
    }

    public void writeNewArticle(String articleID, BBSVO vo) {
        bbs.child(articleID).setValue(vo)
            .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(MainActivity.this, "전송성공", Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, "전송실패", Toast.LENGTH_SHORT).show();
                }
            });
    }
}
