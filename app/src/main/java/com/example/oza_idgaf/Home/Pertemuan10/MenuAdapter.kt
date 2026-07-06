package com.example.oza_idgaf.Home.Pertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide // Import Glide
import com.example.oza_idgaf.R
import com.example.oza_idgaf.databinding.ItemProductGridBinding // Sesuaikan dengan nama layout baru

class MenuAdapter(private var items: List<UmkmItem>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(val binding: ItemProductGridBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = ItemProductGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = items[position]
        holder.binding.tvProductTitle.text = item.title
        holder.binding.tvProductPrice.text = item.description // Gunakan description sebagai harga
        holder.binding.tvProductCategory.text = item.category

        // Gunakan Glide untuk me-load gambar dari internet
        Glide.with(holder.itemView.context)
            .load(item.imageUrl) // Parameter URL gambar
            .placeholder(R.drawable.ic_launcher_background) // Gambar sementara saat loading
            .error(R.drawable.ic_launcher_background) // Gambar jika link error
            .into(holder.binding.imgProduct) // ImageView tujuan
    }

    override fun getItemCount(): Int = items.size

    fun updateData(newItems: List<UmkmItem>) {
        items = newItems
        notifyDataSetChanged()
    }
}