package com.example.oza_idgaf.Pertemuan6

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.oza_idgaf.databinding.ActivityWebviewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebviewBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔹 Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 🔥 SETTING WEBVIEW (INI KUNCI BIAR SCROLL NORMAL)
        binding.webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            loadWithOverviewMode = true
            useWideViewPort = true
        }

        // 🔥 BIAR LINK TETAP DI DALAM WEBVIEW
        binding.webView.webViewClient = WebViewClient()

        // 🔥 FIX SCROLL (ANTI KETAHAN)
        binding.webView.setOnTouchListener { v, _ ->
            v.parent.requestDisallowInterceptTouchEvent(true)
            false
        }

        // 🔥 LOAD URL
        binding.webView.loadUrl("https://oza-umkm.alwaysdata.net/dashboard")
    }

    // 🔙 BACK NAVIGATION (WEBVIEW HISTORY)
    override fun onSupportNavigateUp(): Boolean {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            finish()
        }
        return true
    }

    // 🔙 BACK BUTTON HP
    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}