package com.example.testviewpager2.loop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.testviewpager2.R
import com.example.testviewpager2.databinding.ActivityLoopViewPagerBinding

class LoopViewPagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoopViewPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoopViewPagerBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        initViewPager()
    }

    private fun initViewPager() {
        val pagerAdapter = NewsPagerAdapter(this, supportFragmentManager)
        binding.pager.apply {
            adapter = pagerAdapter
            currentItem = pagerAdapter.centerPosition(0)
            /*addOnPageChangeListener(viewPagerOnPageChangeListener)*/
        }

        binding.tabLayout.apply {
            setUpWithAdapter(LoopVariableTabAdapter(context, binding.pager))
            setIndicatorHeight(0)
        }
    }
}