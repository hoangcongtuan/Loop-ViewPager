package com.example.testviewpager2.undetachviewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.customviewpager2.FragmentViewHolder
import com.example.testviewpager2.PagerFragment
import com.tuanhc.undetach_viewpager.LoopFragmentStateAdapter
import com.tuanhc.undetach_viewpager.UnDetachFragmentStateAdapter

class ImplLoopAdapter(private val fa: FragmentActivity) :
    LoopFragmentStateAdapter<String>(fa) {

    override fun createFragment(position: Int): Fragment {
        return PagerFragment.newInstance(
            getTitle(position)
        )
    }

    private fun getTitle(position: Int): String {
        return "Fragment $position"
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

}