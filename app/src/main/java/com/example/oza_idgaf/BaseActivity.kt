package com.example.oza_idgaf

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.oza_idgaf.Home.HomeFragment
import com.example.oza_idgaf.Home.Pertemuan11.Tutorial.TutorialMessageActivity
import com.example.oza_idgaf.More.MoreFragment
import com.example.oza_idgaf.Home.Pertemuan12.note.FragmentNote
import com.example.oza_idgaf.Home.Pertemuan12.todo.FragmentTodo
import com.example.oza_idgaf.databinding.ActivityBaseBinding
import com.google.android.material.navigation.NavigationBarView

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("USERNAME").orEmpty()

        if (savedInstanceState == null) {
            val homeFragment = HomeFragment().apply {
                arguments = Bundle().apply {
                    putString("USERNAME", username)
                }
            }
            loadFragment(homeFragment)
        }

        binding.bottomNav.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                return when (item.itemId) {
                    R.id.nav_home -> {
                        val homeFragment = HomeFragment().apply {
                            arguments = Bundle().apply {
                                putString("USERNAME", username)
                            }
                        }
                        loadFragment(homeFragment)
                        true
                    }
                    R.id.nav_message -> {
                        val intent = Intent(this@BaseActivity, TutorialMessageActivity::class.java)
                        startActivity(intent)
                        false
                    }
                    R.id.nav_more -> {
                        loadFragment(MoreFragment())
                        true
                    }
                    R.id.navigation_note -> {
                        loadFragment(FragmentNote())
                        true
                    }
                    R.id.navigation_todo -> {
                        loadFragment(FragmentTodo())
                        true
                    }
                    else -> false
                }
            }
        })
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commitAllowingStateLoss()
    }
}