package com.example.app041;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import java.util.StringTokenizer;

public class Main2Activity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    Button getBtn, nextBtn;
    LinearLayout linearLayout;
    static String[] tokens;

    public abstract class MyClickListener implements View.OnClickListener {
        int idx;
        public MyClickListener(int idx) {
            this.idx = idx;
        }
        @Override
        abstract public void onClick(View view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inflation: java + layout
        //java: 내부처리, 이벤트처리, 외부통신
        //layout: view
        setContentView(R.layout.activity_main2);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView2);
        multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView2);
        getBtn = findViewById(R.id.button);
        nextBtn = findViewById(R.id.nextbutton);

        String[] list = new String[]{"airplane", "apple", "melon", "strawberries",
                                     "watermelon", "bonanza", "orange"};
        ArrayAdapter<String> adapter
                = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, list);
        autoCompleteTextView.setAdapter(adapter);

        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(token);

        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String autoText =  autoCompleteTextView.getText().toString();
                String multiText = multiAutoCompleteTextView.getText().toString();
                String total = autoText + ", " + multiText;

                StringTokenizer tokenizer = new StringTokenizer(total);
                int count = tokenizer.countTokens();
                Log.d("token count",count + "");

                tokens = new String[count];
                for(int i=0; i<count; i++) {
                    tokens[i] = tokenizer.nextToken(", ").trim();
                    Log.d(i+"번째 토큰", tokens[i]);
                }

                linearLayout = findViewById(R.id.linear1);
                for(int i=0; i<count; i++) {
                    Button button = new Button(getApplicationContext());
                    button.setText(tokens[i]);
                    button.setWidth(100);
                    button.setTextSize(15);
                    button.setId((i+1) * 100);
                    linearLayout.addView(button);
                    button.setOnClickListener(new MyClickListener(i) {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(), tokens[idx], Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main7Activity.class);
                startActivity(intent);
            }
        });
    }
}
