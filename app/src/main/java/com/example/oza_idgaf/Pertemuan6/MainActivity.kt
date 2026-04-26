package com.example.oza_idgaf.Pertemuan6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.oza_idgaf.PrefManager
import com.example.oza_idgaf.Pertemuan4.LoginActivity
import com.example.oza_idgaf.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var prefManager: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        prefManager = PrefManager(this)

        // 🔥 tombol webview
        binding.btnWeb.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        // 🔐 logout pakai sharedpreferences
        binding.btnLogout.setOnClickListener {
            prefManager.logout()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}