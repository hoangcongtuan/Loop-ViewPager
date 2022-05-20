package com.tuanhc.undetach_viewpager

import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentViewHolder

abstract class LoopFragmentStateAdapter<T>(private val fa: FragmentActivity) :
    UnDetachFragmentStateAdapter(fa) {
    companion object {
        const val NUMBER_OF_LOOPS = 1000000
    }

    private val items: MutableList<T> = mutableListOf()

    override fun getItemCount(): Int {
        return items.size * NUMBER_OF_LOOPS
    }

    private fun submitList(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    private fun getRealCount() = items.size

    private fun getRealPosition(position: Int) = position % items.size

    private fun getItemAt(position: Int): T {
        return items[getRealPosition(position)]
    }
}