package com.example.oza_idgaf.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.oza_idgaf.CatFactApiClient
import com.example.oza_idgaf.Pertemuan10.MenuActivity
import com.example.oza_idgaf.Pertemuan4.Custom1Activity
import com.example.oza_idgaf.Pertemuan4.LoginActivity
import com.example.oza_idgaf.Pertemuan4.RumusBangunRuangActivity
import com.example.oza_idgaf.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = arguments?.getString("USERNAME").orEmpty()
        if (username.isNotEmpty()) {
            binding.tvUserName.text = username
        }

        binding.cardKalkulator.setOnClickListener {
            startActivity(Intent(activity, RumusBangunRuangActivity::class.java))
        }

        binding.cardWebView.setOnClickListener {
            startActivity(Intent(activity, Custom1Activity::class.java))
        }

        binding.cardMenuUmkm.setOnClickListener {
            startActivity(Intent(activity, MenuActivity::class.java))
        }

        binding.cardKeluar.setOnClickListener {
            activity?.let { currentActivity ->
                MaterialAlertDialogBuilder(currentActivity)
                    .setTitle("Konfirmasi Logout")
                    .setMessage("Apakah Anda yakin ingin logout?")
                    .setPositiveButton("Ya") { _, _ ->
                        val intent = Intent(currentActivity, LoginActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                        currentActivity.finish()
                    }
                    .setNegativeButton("Tidak") { dialog, _ ->
                        dialog.dismiss()
                        Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
                    }
                    .show()
            }
        }

        loadCatFact()

        binding.btnRefresh.setOnClickListener {
            loadCatFact()
        }
    }

    private fun loadCatFact() {
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val apiClient = CatFactApiClient
                if (apiClient != null) {
                    val response = apiClient.apiService.getCatFact()
                    if (response != null && !response.fact.isNullOrEmpty()) {
                        binding.tvCatFact.text = "\"${response.fact}\""
                    } else {
                        binding.tvCatFact.text = "Fakta kosong."
                    }
                } else {
                    binding.tvCatFact.text = "API Client belum siap."
                }
            } catch (e: Exception) {
                binding.tvCatFact.text = "Gagal mengambil fakta kucing."
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}