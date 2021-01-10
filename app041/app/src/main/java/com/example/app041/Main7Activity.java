package com.example.app041;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity {
    EditText editUrl;
    Button btnTo, btnBack;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        editUrl = findViewById(R.id.editUrl);
        btnTo = findViewById(R.id.btnTo);
        btnBack = findViewById(R.id.btnPrev);
        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new MyWebViewClient());
        WebSettings settings = webView.getSettings();
        settings.setBuiltInZoomControls(true);

        btnTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Toast.makeText(getApplicationContext(),"GO " + editUrl.getText().toString(), Toast.LENGTH_SHORT).show();
            webView.loadUrl(editUrl.getText().toString());
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Toast.makeText(getApplicationContext(),"BACK", Toast.LENGTH_SHORT).show();
            webView.goBack();
            }
        });
    }

    public class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}
