package com.example.oza_idgaf.Pertemuan2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.oza_idgaf.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("USERNAME") ?: "Pengguna"

        binding.UserName.text = username
    }
}