package com.example.anproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class notice extends AppCompatActivity {

    private WebView noticeVIEW;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        noticeVIEW = findViewById(R.id.WebnoticeView);
        noticeVIEW.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        // Load the given webpage
        noticeVIEW.loadUrl("https://daffodilvarsity.edu.bd/department-notice/transport");
    }
}
