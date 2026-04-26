package com.example.oza_idgaf.Pertemuan6

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.oza_idgaf.PrefManager
import com.example.oza_idgaf.R
import com.example.oza_idgaf.Pertemuan4.LoginActivity
import com.example.oza_idgaf.Pertemuan4.RumusBangunRuangActivity
import com.example.oza_idgaf.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var prefManager: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefManager = PrefManager(this)

        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dashboard Bina Desa"

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnRumus.setOnClickListener {
            startActivity(Intent(this, RumusBangunRuangActivity::class.java))
        }

        binding.btnCustom1.setOnClickListener {
            startActivity(Intent(this, com.example.oza_idgaf.Pertemuan4.Custom1Activity::class.java))
        }

        binding.btnCustom2.setOnClickListener {
            startActivity(Intent(this, com.example.oza_idgaf.Pertemuan4.Custom2Activity::class.java))
        }

        binding.btnPertemuan5.setOnClickListener {
            startActivity(Intent(this, com.example.oza_idgaf.Pertemuan5.ToolbarActivity::class.java))
        }

        binding.btnPertemuan6.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            prefManager.isLogin = false  // ← RESET STATUS LOGIN
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_dashboard, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            R.id.action_webview -> {
                startActivity(Intent(this, WebViewActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}