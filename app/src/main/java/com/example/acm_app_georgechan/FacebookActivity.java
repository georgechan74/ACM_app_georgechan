package com.example.acm_app_georgechan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FacebookActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Facebook");
        setContentView(R.layout.facebook_webview);

        WebView myWebView = (WebView) findViewById(R.id.facebook_webview);
        myWebView.setWebViewClient(new WebViewClient());

        myWebView.loadUrl("https://www.facebook.com/calstatela.acm");
    }
}
