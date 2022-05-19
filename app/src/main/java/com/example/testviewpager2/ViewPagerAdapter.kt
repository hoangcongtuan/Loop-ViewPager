package com.example.testviewpager2

import android.util.Log
import android.util.LongSparseArray
import android.util.SparseLongArray
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 20
    }

    override fun createFragment(position: Int): Fragment {
        return PagerFragment.newInstance(
            "Fragment $position"
        )
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        Log.d(TAG, "onDetachedFromRecyclerView: ")
    }

    companion object {
        private const val TAG = "ViewPagerAdapter"
    }

}