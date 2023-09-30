package com.example.riverwise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    public static final String EXTRA_PDF_FILE = "pdf_file";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);

        // Enable JavaScript (if needed)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Set a WebViewClient to handle page navigation within the WebView
        webView.setWebViewClient(new WebViewClient());

        // Define the URL you want to open
        String url = getIntent().getStringExtra(EXTRA_PDF_FILE);

        // Load the URL in the WebView
        webView.loadUrl(url);
    }
}