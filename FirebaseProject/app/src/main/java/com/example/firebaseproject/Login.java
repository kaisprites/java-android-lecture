package com.example.firebaseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    DatabaseReference users;
    Button btnLogin, btnCancel;
    EditText editId, editPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        btnCancel = findViewById(R.id.btnCancel);
        editId = findViewById(R.id.id);
        editPw = findViewById(R.id.pw);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        //로그인의 구현 (리스트 받아와서 하나씩 대조, 맞는게 있으면 로그인 처리)
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                users = FirebaseDatabase.getInstance().getReference("/project/users");
                final String id = editId.getText().toString();
                final String pw = editPw.getText().toString();

                users.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        UserVO myAccount = new UserVO(id, pw);
                        for(DataSnapshot d : snapshot.getChildren()) {
                            UserVO account = d.getValue(UserVO.class);
                            Log.d(myAccount.toString(), account.toString());
                            if (myAccount.equals(account)) {
                                Log.d("로그인 성공", "로그인 성공");
                                Intent intent = new Intent();
                                intent.putExtra("id", id);
                                setResult(RESULT_OK, intent);
                                finish();
                            }
                        }
                        Toast.makeText(Login.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }
}
