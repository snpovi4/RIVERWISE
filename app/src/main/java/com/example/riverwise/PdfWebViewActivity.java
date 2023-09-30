package com.example.riverwise;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class PdfWebViewActivity extends AppCompatActivity {

    public static final String EXTRA_PDF_FILE = "pdf_file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_web_view);

        WebView pdfWebView = findViewById(R.id.pdfWebView);

        // Enable JavaScript (if needed)
        pdfWebView.getSettings().setJavaScriptEnabled(false);
        pdfWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        pdfWebView.getSettings().setLoadWithOverviewMode(true);
        pdfWebView.getSettings().setUseWideViewPort(true);



        // Get the PDF file name or resource ID from the intent extra
        String pdfFileName = getIntent().getStringExtra(EXTRA_PDF_FILE);
        Log.d(TAG, "onCreate: +"+pdfFileName);
        // Load the PDF from the raw folder or a URL based on the parameter
        if (pdfFileName != null && pdfFileName.startsWith("http")) {
            // Load PDF from a URL
            pdfWebView.loadUrl(pdfFileName);
        } else if (pdfFileName != null) {
            // Load PDF from the raw folder
            int pdfResource = getResources().getIdentifier(pdfFileName, "raw", getPackageName());
            pdfWebView.loadUrl("file:///android_res/raw/" + pdfResource);
        }

        // Set a WebViewClient to handle links within the WebView
        pdfWebView.setWebViewClient(new WebViewClient());
    }
}
