package com.unicaldas.cursomoviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_university.*

class UniversityActivity : AppCompatActivity() {
    private val BASE_URL = "https://google.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_university)

        //WebView
        webView.webChromeClient = object : WebChromeClient() {

        }

        webView.webViewClient = object : WebViewClient() {

        }
        val settings: WebSettings = webView.settings
        settings.javaScriptEnabled = true
        webView.loadUrl(BASE_URL)

    }
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

}