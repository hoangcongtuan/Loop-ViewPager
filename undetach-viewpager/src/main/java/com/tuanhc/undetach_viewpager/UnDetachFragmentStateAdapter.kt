package com.tuanhc.undetach_viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder

abstract class UnDetachFragmentStateAdapter(private val fa: FragmentActivity) : com.example.customviewpager2.FragmentStateAdapter(fa) {
    /*abstract override fun getItemCount(): Int*/

   /* override fun createFragment(position: Int): Fragment {
        TODO("Not yet implemented")
    }*/

    /*override fun createFragment(position: Int): Fragment {
        TODO("Not yet implemented")
    }*/


    /*override fun onBindViewHolder(
        holder: FragmentViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
        holder.setIsRecyclable(false)
    }*/

   /* override fun onBindViewHolder(
        holder: com.example.customviewpager2.FragmentViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
        holder.setIsRecyclable(false)    }*/
}