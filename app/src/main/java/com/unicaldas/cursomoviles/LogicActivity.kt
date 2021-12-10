package com.unicaldas.cursomoviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_logic.*

class LogicActivity : AppCompatActivity() {
    private val BASE_URL = "https://www.cokitos.com/tag/juegos-de-inteligencia/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logic)

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