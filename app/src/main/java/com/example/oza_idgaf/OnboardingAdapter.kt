package com.example.oza_idgaf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnboardingAdapter(
    private val titles: List<String>,
    private val descs: List<String>,
    private val images: List<Int>
) : RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    class OnboardingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivOnboarding: ImageView = view.findViewById(R.id.ivOnboarding)
        val tvTitleOnboarding: TextView = view.findViewById(R.id.tvTitleOnboarding)
        val tvDescOnboarding: TextView = view.findViewById(R.id.tvDescOnboarding)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_onboarding, parent, false)
        return OnboardingViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.tvTitleOnboarding.text = titles[position]
        holder.tvDescOnboarding.text = descs[position]
        holder.ivOnboarding.setImageResource(images[position])
    }

    override fun getItemCount(): Int = titles.size
}