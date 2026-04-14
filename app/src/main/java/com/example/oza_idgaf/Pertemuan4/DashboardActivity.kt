package com.example.oza_idgaf.Pertemuan4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.oza_idgaf.databinding.ActivityDashboardBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("USERNAME").orEmpty()
        binding.tvWelcomeTitle.text = "Selamat Datang, $username"
        binding.tvWelcomeDesc.text = "Pilih menu yang ingin dibuka dari halaman utama."

        binding.btnRumus.setOnClickListener {
            startActivity(Intent(this, RumusBangunRuangActivity::class.java))
        }

        binding.btnCustom1.setOnClickListener {
            startActivity(Intent(this, Custom1Activity::class.java))
        }

        binding.btnCustom2.setOnClickListener {
            startActivity(Intent(this, Custom2Activity::class.java))
        }

        binding.btnPertemuan5.setOnClickListener {
            startActivity(Intent(this, com.example.oza_idgaf.Pertemuan5.ToolbarActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { _, _ ->
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                    Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}