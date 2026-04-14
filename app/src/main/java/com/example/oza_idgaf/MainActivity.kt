package com.example.oza_idgaf

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPanjangDatar = findViewById<EditText>(R.id.etPanjangDatar)
        val etLebarDatar = findViewById<EditText>(R.id.etLebarDatar)
        val btnHitungDatar = findViewById<Button>(R.id.btnHitungDatar)
        val tvHasilDatar = findViewById<TextView>(R.id.tvHasilDatar)

        // tombol btn hitung luas saat kita tekan
        btnHitungDatar.setOnClickListener {
            val panjangStr = etPanjangDatar.text.toString()
            val lebarStr = etLebarDatar.text.toString()

            if (panjangStr.isNotEmpty() && lebarStr.isNotEmpty()) {
                val panjang = panjangStr.toDouble()
                val lebar = lebarStr.toDouble()
                val luas = panjang * lebar
                tvHasilDatar.text = "Hasil Luas: $luas"
            } else {
                Toast.makeText(this, "Panjang dan Lebar tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
        }

        val etPanjangRuang = findViewById<EditText>(R.id.etPanjangRuang)
        val etLebarRuang = findViewById<EditText>(R.id.etLebarRuang)
        val etTinggiRuang = findViewById<EditText>(R.id.etTinggiRuang)
        val btnHitungRuang = findViewById<Button>(R.id.btnHitungRuang)
        val tvHasilRuang = findViewById<TextView>(R.id.tvHasilRuang)

        //  yombol hitung volume saat kita tekan
        btnHitungRuang.setOnClickListener {
            val panjangStr = etPanjangRuang.text.toString()
            val lebarStr = etLebarRuang.text.toString()
            val tinggiStr = etTinggiRuang.text.toString()

            if (panjangStr.isNotEmpty() && lebarStr.isNotEmpty() && tinggiStr.isNotEmpty()) {
                val panjang = panjangStr.toDouble()
                val lebar = lebarStr.toDouble()
                val tinggi = tinggiStr.toDouble()
                val volume = panjang * lebar * tinggi
                tvHasilRuang.text = "Hasil Volume: $volume"
            } else {
                Toast.makeText(this, "Semua inputan harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}