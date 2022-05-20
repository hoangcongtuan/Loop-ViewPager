package com.example.testviewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.testviewpager2.databinding.ActivityUnDetachViewPager2Binding

class LoopViewPager2Activity : AppCompatActivity() {
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
        val adapter = ImplLoopAdapter(this)
        adapter.submitList(
            List(20) { it.toString() }
        )
        binding.viewPager.apply {
            offscreenPageLimit
            setAdapter(adapter)
            setCurrentItem(adapter.itemCount / 2, false)
        }
    }
}