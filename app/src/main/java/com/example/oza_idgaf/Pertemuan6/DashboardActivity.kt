package com.example.oza_idgaf.Pertemuan6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.oza_idgaf.Pertemuan4.Custom1Activity
import com.example.oza_idgaf.Pertemuan4.Custom2Activity
import com.example.oza_idgaf.Pertemuan4.RumusBangunRuangActivity
import com.example.oza_idgaf.Pertemuan5.ToolbarActivity
import com.example.oza_idgaf.databinding.ActivityDashboardBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var prefManager: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefManager = PrefManager(this)

        val username = intent.getStringExtra("USERNAME").orEmpty()
        binding.tvWelcomeTitle.text = "Selamat Datang, $username"
        binding.tvWelcomeDesc.text = "Pilih menu yang ingin dibuka dari halaman utama."

        // 🔹 PERTEMUAN 4
        binding.btnRumus.setOnClickListener {
            startActivity(Intent(this, RumusBangunRuangActivity::class.java))
        }

        binding.btnCustom1.setOnClickListener {
            startActivity(Intent(this, Custom1Activity::class.java))
        }

        binding.btnCustom2.setOnClickListener {
            startActivity(Intent(this, Custom2Activity::class.java))
        }

        // 🔹 PERTEMUAN 5
        binding.btnPertemuan5.setOnClickListener {
            startActivity(Intent(this, ToolbarActivity::class.java))
        }

        // 🔥 PERTEMUAN 6 (WEBVIEW LU)
        binding.btnPertemuan6.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        // 🔥 LOGOUT SUDAH BENAR (PAKAI PREF)
        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { _, _ ->

                    // ❗ INI YANG PENTING
                    prefManager.logout()

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