package com.example.oza_idgaf.Pertemuan4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.oza_idgaf.databinding.ActivityRumusBangunRuangBinding

class RumusBangunRuangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRumusBangunRuangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRumusBangunRuangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener {
            val p = binding.etPanjang.text?.toString()?.trim().orEmpty()
            val l = binding.etLebar.text?.toString()?.trim().orEmpty()
            val t = binding.etTinggi.text?.toString()?.trim().orEmpty()

            if (p.isEmpty() || l.isEmpty() || t.isEmpty()) {
                binding.tvHasil.text = "Semua input harus diisi."
                return@setOnClickListener
            }

            val panjang = p.toDouble()
            val lebar = l.toDouble()
            val tinggi = t.toDouble()
            val volume = panjang * lebar * tinggi

            binding.tvHasil.text = "Hasil volume balok: $volume"
        }
    }
}