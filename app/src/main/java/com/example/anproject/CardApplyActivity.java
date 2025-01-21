package com.example.anproject;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class CardApplyActivity extends AppCompatActivity {

    private WebView applyVIEW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_apply);

        applyVIEW = findViewById(R.id.WebapplyView);

        WebSettings webSettings = applyVIEW.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enable JavaScript if needed
        webSettings.setDomStorageEnabled(true);

        applyVIEW.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                Log.e("CardApplyActivity", "Error: " + description);
            }
        });

        // Load the given webpage
        applyVIEW.loadUrl("http://studentportal.diu.edu.bd/#/bus-pass-card-list");
    }
}
