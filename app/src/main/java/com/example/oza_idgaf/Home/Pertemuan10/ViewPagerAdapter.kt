package com.example.oza_idgaf.Home.Pertemuan10

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    // Jumlah total tab (Kuliner, Kerajinan, Kesehatan)
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        // Mengirimkan kategori yang berbeda ke fragment list berdasarkan posisi swipe
        return when (position) {
            0 -> MenuCategoryFragment.newInstance("Kuliner")
            1 -> MenuCategoryFragment.newInstance("Kerajinan")
            else -> MenuCategoryFragment.newInstance("Kesehatan")
        }
    }
}