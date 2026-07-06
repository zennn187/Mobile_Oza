package com.example.oza_idgaf.Home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.oza_idgaf.Home.Pertemuan10.MenuActivity
import com.example.oza_idgaf.Home.Pertemuan11.Tutorial.TutorialMessageActivity
import com.example.oza_idgaf.Home.Pertemuan12.note.NoteFormActivity
import com.example.oza_idgaf.Home.Pertemuan13.ThirteenthActivity
import com.example.oza_idgaf.Home.Pertemuan2.WelcomeActivity
import com.example.oza_idgaf.Home.Pertemuan4.DashboardActivity as DashboardP4
import com.example.oza_idgaf.Home.Pertemuan6.DashboardActivity as DashboardP6
import com.example.oza_idgaf.Home.Pertemuan5.ToolbarActivity
import com.example.oza_idgaf.Home.Pertemuan9.NinthActivity
import com.example.oza_idgaf.databinding.ActivityAllMeetingsBinding

class AllMeetingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAllMeetingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllMeetingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupClickListeners()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setupClickListeners() {
        binding.cardP2.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }
        binding.cardP4.setOnClickListener {
            startActivity(Intent(this, DashboardP4::class.java))
        }
        binding.cardP5.setOnClickListener {
            startActivity(Intent(this, ToolbarActivity::class.java))
        }
        binding.cardP6.setOnClickListener {
            startActivity(Intent(this, DashboardP6::class.java))
        }
        binding.cardP9.setOnClickListener {
            startActivity(Intent(this, NinthActivity::class.java))
        }
        binding.cardP10.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
        binding.cardP11.setOnClickListener {
            startActivity(Intent(this, TutorialMessageActivity::class.java))
        }
        binding.cardP12.setOnClickListener {
            startActivity(Intent(this, NoteFormActivity::class.java))
        }
        binding.cardP13.setOnClickListener {
            startActivity(Intent(this, ThirteenthActivity::class.java))
        }
        binding.cardP14.setOnClickListener {
            // Placeholder untuk P14 karena belum ada activity utama
            startActivity(Intent(this, NinthActivity::class.java))
        }
    }
}
