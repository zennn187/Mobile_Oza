package com.example.oza_idgaf.Pertemuan10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.oza_idgaf.databinding.ActivityMenuBinding
import com.google.android.material.tabs.TabLayoutMediator

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private val tabTitles = arrayOf("Kuliner", "Kerajinan", "Kesehatan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Pasangkan ViewPagerAdapter ke ViewPager2
        val pagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter

        // 2. Hubungkan TabLayout dengan ViewPager2 agar bisa bergeser sinkron saat di-swipe
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}