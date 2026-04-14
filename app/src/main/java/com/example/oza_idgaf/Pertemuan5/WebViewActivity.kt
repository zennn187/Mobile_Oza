package com.example.oza_idgaf.Pertemuan5

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.oza_idgaf.databinding.ActivityWebviewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webView.settings.javaScriptEnabled = true

        binding.webView.webViewClient = WebViewClient()

        binding.webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                binding.progressBar.progress = newProgress

                if (newProgress == 100) {
                    binding.progressBar.animate()
                        .alpha(0f)
                        .setDuration(300)
                        .withEndAction {
                            binding.progressBar.visibility = View.GONE
                        }
                } else {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.progressBar.alpha = 1f
                }
            }
        }

        onBackPressedDispatcher.addCallback(this) {
            if (binding.webView.canGoBack()) {
                binding.webView.goBack()
            } else {
                Toast.makeText(this@WebViewActivity, "Keluar dari WebView", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        binding.webView.loadUrl("https://www.google.com")
    }
}