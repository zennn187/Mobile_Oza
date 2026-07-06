package com.example.oza_idgaf.Home.Pertemuan6

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.oza_idgaf.R
import com.example.oza_idgaf.databinding.ActivityMain2Binding
import android.content.SharedPreferences
import com.example.oza_idgaf.Home.HomeFragment
import com.example.oza_idgaf.Message.MessageFragment
import com.example.oza_idgaf.More.MoreFragment
import com.example.oza_idgaf.Home.Pertemuan12.note.FragmentNote
import com.example.oza_idgaf.Home.Pertemuan12.todo.FragmentTodo
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("OzaPrefs", MODE_PRIVATE)

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        binding.bottomNav.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                return when (item.itemId) {
                    R.id.nav_home -> {
                        replaceFragment(HomeFragment())
                        true
                    }
                    R.id.nav_message -> {
                        replaceFragment(MessageFragment())
                        true
                    }
                    R.id.nav_more -> {
                        replaceFragment(MoreFragment())
                        true
                    }
                    R.id.navigation_note -> {
                        replaceFragment(FragmentNote())
                        true
                    }
                    R.id.navigation_todo -> {
                        replaceFragment(FragmentTodo())
                        true
                    }
                    else -> false
                }
            }
        })
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commitAllowingStateLoss()
    }
}