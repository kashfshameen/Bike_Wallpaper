package com.kashf.developer.bikewallpaper;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class privacy extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        webView=(WebView)findViewById(R.id.web);
webView.loadUrl("file:///android_asset/privacy.html");
    }
}