package com.example.testviewpager2.undetachviewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.testviewpager2.PagerFragment
import com.tuanhc.undetach_viewpager.UnDetachFragmentStateAdapter

class ImplUnDetachPagerAdapter(private val fa: FragmentActivity) :
    UnDetachFragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return 3
    }

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