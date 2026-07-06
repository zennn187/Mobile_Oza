package com.example.oza_idgaf

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.oza_idgaf.Home.Pertemuan4.LoginActivity
import com.example.oza_idgaf.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titles = listOf("Selamat Datang", "Digitalisasi UMKM", "Pantau Data")
        val descs = listOf("Aplikasi manajemen pusat data UMKM Bina Desa.", "Kembangkan potensi usaha desa dengan teknologi.", "Kelola kalkulator rumus dan pantau statistik informasi.")
        val images = listOf(android.R.drawable.ic_dialog_info, android.R.drawable.ic_menu_share, android.R.drawable.ic_menu_agenda)

        val adapter = OnboardingAdapter(titles, descs, images)
        binding.viewPager.adapter = adapter

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == titles.size - 1) {
                    binding.btnStart.visibility = View.VISIBLE
                } else {
                    binding.btnStart.visibility = View.GONE
                }
            }
        })

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}