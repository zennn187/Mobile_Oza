package com.example.oza_idgaf.Pertemuan6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.oza_idgaf.Home.HomeFragment
import com.example.oza_idgaf.R
import com.example.oza_idgaf.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = SharedPreferences(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()

                .replace(binding.root.id, HomeFragment())
                .commit()
        }
    }
}