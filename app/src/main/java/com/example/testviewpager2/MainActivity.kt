package com.example.testviewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewpager.widget.PagerAdapter
import com.example.testviewpager2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val pagerAdapter = ViewPagerAdapter(this)
        binding.viewpager.adapter = pagerAdapter
        binding.viewpager.offscreenPageLimit = 10
    }
}