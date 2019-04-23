package com.example.acm_app_georgechan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class InstagramActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Instagram");
        setContentView(R.layout.instagram_webview);

        WebView myWebView = (WebView) findViewById(R.id.instagram_webview);
        myWebView.setWebViewClient(new WebViewClient());

        myWebView.loadUrl("https://www.instagram.com/calstatela_acm/");
    }
}
