package com.example.testviewpager2.undetachviewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.testviewpager2.R
import com.example.testviewpager2.databinding.ActivityUnDetachViewPager2Binding
import com.tuanhc.undetach_viewpager.UnDetachFragmentStateAdapter

class UnDetachViewPager2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityUnDetachViewPager2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnDetachViewPager2Binding.inflate(
            LayoutInflater.from(this)
        )
        setContentView(binding.root)
        initViewPager()
    }

    private fun initViewPager() {
        val adapter = ImplUnDetachPagerAdapter(this)
        binding.viewPager.apply {
            offscreenPageLimit
            setAdapter(adapter)
        }
    }
}