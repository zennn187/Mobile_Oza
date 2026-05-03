package com.example.oza_idgaf.Message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.oza_idgaf.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)

        binding.tvTitle.text = "UMKM - Bina Desa"

        binding.tvDesc.text = """
            Bina Desa UMKM adalah sebuah konsep pengembangan desa berbasis teknologi 
            yang bertujuan untuk meningkatkan kesejahteraan masyarakat melalui 
            pemanfaatan sistem informasi dan digitalisasi layanan.
        """.trimIndent()

        binding.tvFitur.text = """
            • Informasi dan Profil UMKM
            • Digitalisasi UMKM Lokal
            • Edukasi & Pelatihan Masyarakat
            • Promosi Produk UMKM
        """.trimIndent()

        binding.container.alpha = 0f
        binding.container.translationY = 50f

        binding.container.animate()
            .alpha(1f)
            .translationY(0f)
            .setDuration(700)
            .start()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}