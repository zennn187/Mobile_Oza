package com.example.oza_idgaf.More

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.oza_idgaf.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        
        setupActionButtons()
        
        return binding.root
    }

    private fun setupActionButtons() {
        // Social Media & Links
        binding.btnLinkedIn.setOnClickListener {
            openUrl("https://www.linkedin.com/in/oza-okta-gistrada")
        }

        binding.btnInstagram.setOnClickListener {
            openUrl("https://www.instagram.com/oza.oktaa")
        }

        binding.tvWebsite.setOnClickListener {
            openUrl("https://oza.oktaa")
        }

        binding.cardWebsite.setOnClickListener {
            openUrl("https://oza.oktaa")
        }

        // WhatsApp Logic
        binding.btnSocialWhatsApp.setOnClickListener {
            openWhatsApp()
        }

        binding.fabWhatsApp.setOnClickListener {
            openWhatsApp()
        }

        // Logout
        binding.btnLogout.setOnClickListener {
            Toast.makeText(context, "Berhasil Keluar", Toast.LENGTH_SHORT).show()
            // Logika logout bisa ditambahkan di sini (misal: intent ke LoginActivity)
            activity?.finish()
        }
    }

    private fun openUrl(url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Tidak dapat membuka tautan", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openWhatsApp() {
        val nomorWa = "6289505647628"
        val pesan = "Halo Oza, saya ingin bertanya seputar program UMKM Bina Desa."
        
        val url = "https://api.whatsapp.com/send?phone=$nomorWa&text=${Uri.encode(pesan)}"
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Aplikasi WhatsApp tidak ditemukan", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
