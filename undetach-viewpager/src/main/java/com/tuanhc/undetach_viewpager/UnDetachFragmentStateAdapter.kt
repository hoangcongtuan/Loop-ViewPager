package com.tuanhc.undetach_viewpager

import androidx.fragment.app.FragmentActivity

abstract class UnDetachFragmentStateAdapter(private val fa: FragmentActivity) : com.example.customviewpager2.FragmentStateAdapter(fa) {
   /* override fun onBindViewHolder(
        holder: com.example.customviewpager2.FragmentViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
        holder.setIsRecyclable(false)    }*/
}