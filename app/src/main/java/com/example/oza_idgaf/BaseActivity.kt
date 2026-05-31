package com.example.oza_idgaf

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.oza_idgaf.More.MoreFragment
import com.example.oza_idgaf.databinding.ActivityBaseBinding

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

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
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
                    val intent = Intent(this, com.example.oza_idgaf.Tutorial.TutorialMessageActivity::class.java)
                    startActivity(intent)
                    false
                }
                R.id.nav_more -> {
                    loadFragment(MoreFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}