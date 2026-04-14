package com.example.oza_idgaf.Pertemuan5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.oza_idgaf.R
import com.example.oza_idgaf.databinding.ActivityToolbarBinding

class ToolbarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityToolbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.toolbar.setOnClickListener {
            startActivity(Intent(this, com.example.oza_idgaf.Pertemuan4.DashboardActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_home -> {
                return true
            }

            R.id.menu_dark -> {
                item.isChecked = !item.isChecked
                return true
            }

            R.id.menu_light -> {
                item.isChecked = !item.isChecked
                return true
            }

            R.id.menu_web -> {
                startActivity(Intent(this, WebViewActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}