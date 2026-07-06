package com.example.oza_idgaf.Home.Pertemuan6

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.oza_idgaf.Home.Pertemuan4.Custom1Activity
import com.example.oza_idgaf.Home.Pertemuan4.Custom2Activity
import com.example.oza_idgaf.R
import com.example.oza_idgaf.Home.Pertemuan4.LoginActivity
import com.example.oza_idgaf.Home.Pertemuan4.RumusBangunRuangActivity
import com.example.oza_idgaf.Home.Pertemuan5.ToolbarActivity
import com.example.oza_idgaf.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = SharedPreferences(this)

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
            startActivity(Intent(this, Custom1Activity::class.java))
        }

        binding.btnCustom2.setOnClickListener {
            startActivity(Intent(this, Custom2Activity::class.java))
        }

        binding.btnPertemuan5.setOnClickListener {
            startActivity(Intent(this, ToolbarActivity::class.java))
        }

        binding.btnPertemuan6.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            sharedPreferences.isLogin = false
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