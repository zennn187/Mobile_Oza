package com.example.oza_idgaf.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.oza_idgaf.Pertemuan4.LoginActivity
import com.example.oza_idgaf.Pertemuan4.RumusBangunRuangActivity
import com.example.oza_idgaf.Pertemuan6.SharedPreferences
import com.example.oza_idgaf.Pertemuan6.WebViewActivity
import com.example.oza_idgaf.R

class HomeFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        sharedPreferences = SharedPreferences(requireContext())

        val tvUserName = view.findViewById<TextView>(R.id.tvUserName)
        val cardKalkulator = view.findViewById<CardView>(R.id.cardKalkulator)
        val cardWebView = view.findViewById<CardView>(R.id.cardWebView)
        val cardInfo = view.findViewById<CardView>(R.id.cardInfo)
        val cardKeluar = view.findViewById<CardView>(R.id.cardKeluar)

        val namaUser = sharedPreferences.getNama()
        if (namaUser.isNotEmpty()) {
            tvUserName.text = namaUser
        }

        cardKalkulator.setOnClickListener {
            val intent = Intent(activity, RumusBangunRuangActivity::class.java)
            startActivity(intent)
        }

        cardWebView.setOnClickListener {
            val intent = Intent(activity, WebViewActivity::class.java)
            startActivity(intent)
        }

        cardInfo.setOnClickListener {
            Toast.makeText(context, "Fitur Info Proyek UMKM Oza Idgaf", Toast.LENGTH_SHORT).show()
        }

        cardKeluar.setOnClickListener {
            sharedPreferences.isLogin = false

            val intent = Intent(activity, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            activity?.finish()
        }

        return view
    }
}