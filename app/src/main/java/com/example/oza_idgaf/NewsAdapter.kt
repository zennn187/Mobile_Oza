package com.example.oza_idgaf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(private val articles: List<Article>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivNews: ImageView = view.findViewById(R.id.ivNews)
        val tvNewsTitle: TextView = view.findViewById(R.id.tvNewsTitle)
        val tvNewsDesc: TextView = view.findViewById(R.id.tvNewsDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articles[position]
        holder.tvNewsTitle.text = article.title.orEmpty()
        holder.tvNewsDesc.text = article.description.orEmpty()

        Glide.with(holder.itemView.context)
            .load(article.urlToImage)
            .placeholder(android.R.drawable.ic_menu_report_image)
            .into(holder.ivNews)
    }

    override fun getItemCount(): Int = articles.size
}