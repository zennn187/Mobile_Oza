package com.example.oza_idgaf.Tutorial

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.oza_idgaf.R
import com.example.oza_idgaf.databinding.ActivityTutorialMessageBinding


class TutorialMessageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialMessageBinding
    private val fragments = listOf(
        Tutorial1Fragment(),
        Tutorial2Fragment(),
        Tutorial3Fragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityTutorialMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupViewPager()
        setupIndicators()
        setCurrentIndicator(0)

        binding.btnTutorialAction.setOnClickListener {
            val currentItem = binding.viewPagerTutorial.currentItem
            if (currentItem < fragments.size - 1) {
                binding.viewPagerTutorial.currentItem = currentItem + 1
            } else {
                finish()
            }
        }
    }

    private fun setupViewPager() {
        val adapter = TutorialFragmentAdapter(this, fragments)
        binding.viewPagerTutorial.adapter = adapter

        binding.viewPagerTutorial.setPageTransformer { page, position ->
            page.translationX = -position * page.width
            if (position < -1 || position > 1) {
                page.alpha = 0f
            } else if (position <= 0f) {
                page.alpha = 1f
                page.scaleX = 1f
                page.scaleY = 1f
            } else {
                page.alpha = 1f - position
                page.scaleX = 1f - position * 0.25f
                page.scaleY = 1f - position * 0.25f
            }
        }

        binding.viewPagerTutorial.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)

                if (position == fragments.size - 1) {
                    binding.btnTutorialAction.text = "Mulai Sekarang"
                    binding.btnTutorialAction.backgroundTintList = ContextCompat.getColorStateList(
                        this@TutorialMessageActivity, android.R.color.holo_green_dark
                    )
                } else {
                    binding.btnTutorialAction.text = "Lanjut"
                    binding.btnTutorialAction.backgroundTintList = ContextCompat.getColorStateList(
                        this@TutorialMessageActivity, android.R.color.holo_blue_dark
                    )
                }
            }
        })
    }

    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(fragments.size)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8, 0, 8, 0)

        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive))
            indicators[i]?.layoutParams = layoutParams
            binding.layoutIndicators.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = binding.layoutIndicators.childCount
        for (i in 0 until childCount) {
            val imageView = binding.layoutIndicators.getChildAt(i) as ImageView
            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.dot_active))
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive))
            }
        }
    }
}