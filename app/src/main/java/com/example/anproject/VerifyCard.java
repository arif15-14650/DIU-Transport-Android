package com.example.anproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class VerifyCard extends AppCompatActivity {

    private WebView verifyCardWebView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_card);

        verifyCardWebView = findViewById(R.id.WebverifyView);

        WebSettings webSettings = verifyCardWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        verifyCardWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // Load the URL in the WebView
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);

            }
        });

        // Load the specified URL
        verifyCardWebView.loadUrl("http://studentportal.diu.edu.bd/#/transport?studentId=yourStudentId");
    }
}
