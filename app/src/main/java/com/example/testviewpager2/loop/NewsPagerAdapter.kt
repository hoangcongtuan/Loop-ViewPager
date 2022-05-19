package com.example.testviewpager2.loop

import android.content.Context
import android.view.ViewGroup
import com.example.testviewpager2.PagerFragment
import com.nshmura.recyclertablayout.LoopPagerAdapter
import com.nshmura.recyclertablayout.LoopTabItem

/**
 * ニュース画面の ViewPager で使う PagerAdapter
 */
class NewsPagerAdapter(
    context: Context,
    fm: androidx.fragment.app.FragmentManager
) : LoopPagerAdapter(context, fm) {
    private val tabItems: List<LoopTabItem> by lazy {
        val items = mutableListOf<LoopTabItem>()
        repeat(3) {
            items.add(LoopTabItem("Title $it"))
        }
        items
    }

    var currentFragment: androidx.fragment.app.Fragment? = null
        private set

    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        super.setPrimaryItem(container, position, `object`)

        currentFragment = (`object` as? androidx.fragment.app.Fragment)
    }

    override val items: List<LoopTabItem>
        get() = tabItems

    override fun getItem(position: Int): PagerFragment {
        return PagerFragment.newInstance("Fragment ${getPageTitle(position)}")
    }

    override fun getBadge(position: Int): Int {
        return 0
    }
}
