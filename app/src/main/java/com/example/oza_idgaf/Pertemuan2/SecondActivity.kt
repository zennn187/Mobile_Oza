package com.example.oza_idgaf.Pertemuan2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.oza_idgaf.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.Username.text.toString().trim()
            val password = binding.Password.text.toString().trim()

            if (username.isEmpty()) {
                binding.Username.error = "Username tidak boleh kosong"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.Password.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }

            val intent = Intent(this, WelcomeActivity::class.java)
            intent.putExtra("USERNAME", username)
            startActivity(intent)
        }
    }
}