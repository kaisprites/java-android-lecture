package com.example.fire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    DatabaseReference firebaseDatabase;
    MyListAdapter adapter;
    EditText editUsername, editEmail;
    Button btnSave, btnRead;
    TextView readData;
    int i = 1;
    ListView listView;
    TextView text1, text2;

    ArrayList<User> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUsername = findViewById(R.id.editText3);
        editEmail = findViewById(R.id.editText4);
        btnSave = findViewById(R.id.button);
        btnRead = findViewById(R.id.button2);
        readData = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);

        firebaseDatabase = FirebaseDatabase.getInstance().getReference("users");
        Log.d("firebase",  firebaseDatabase+" ");

        arrayList = new ArrayList<>();


        firebaseDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                Log.d("firebase","user>children count: " +  snapshot.getChildrenCount());
                for(DataSnapshot snapshot1: snapshot.getChildren()) {
                    User user = snapshot1.getValue(User.class);
                    arrayList.add(user);
                    Log.d("firebase",user.toString());
                }
                i = arrayList.size();

                adapter = new MyListAdapter(getApplicationContext(), arrayList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getUserName = editUsername.getText().toString();
                String getEmail = editEmail.getText().toString();

                HashMap result = new HashMap<>();
                result.put("name", getUserName);
                result.put("email", getEmail);
                i++;
                writeNewUser(i+"", getUserName, getEmail);
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readUser();
            }
        });
    }

    private void writeNewUser(String userID, String name, String email){
        User user = new User(name, email);
        firebaseDatabase.child(userID).setValue(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "저장완료", Toast.LENGTH_SHORT).show();
                        adapter.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "저장실패", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void readUser() {
        firebaseDatabase.child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue(User.class) != null) {
                    User post = snapshot.getValue(User.class);
                    Log.w("FirebaseData", "GetData" + post.toString());
                    readData.setText(post.username + " " + post.email);
                } else {
                    Toast.makeText(MainActivity.this, "데이터 없음", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("FirebaseData", "loadPost:onCancelled", error.toException());
            }
        });
    }
}
