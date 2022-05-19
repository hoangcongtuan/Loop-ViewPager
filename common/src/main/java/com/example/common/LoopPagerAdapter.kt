package com.example.common

import android.content.Context
import android.database.DataSetObserver
import androidx.annotation.DrawableRes
import androidx.fragment.app.FragmentManager
/**
 * 左右にループする ViewPager で使う PagerAdapter
 *
 * 扱う Fragment を detach せずに保持したいので UnDetachableFragmentPagerAdapter を継承する。
 *
 * ViewPager でなら offscreenPageLimit を設定して destroyItem せずに保持できるが、
 * LoopViewPager で offscreenPageLimit を設定するとスワイプの挙動に影響があるので PagerAdapter のほうで対処する。
 */
abstract class LoopPagerAdapter(
    context: Context,
    fm: androidx.fragment.app.FragmentManager
) : UnDetachableFragmentPagerAdapter(fm) {
    companion object {
        const val NUMBER_OF_LOOPS = 1000000
    }
    private val context = context

    abstract val items: List<LoopTabItem>

    override fun getCount(): Int = items.size * NUMBER_OF_LOOPS

    override fun getPageTitle(position: Int): CharSequence {
        return "Title ${getRealPosition(position)}"
    }

    public fun setViewPagerObserver_public(observer: DataSetObserver?) {
        setViewPagerObserver(observer)
    }

    abstract fun getBadge(position: Int): Int

    fun centerPosition(position: Int): Int {
        return items.size * NUMBER_OF_LOOPS / 2 + position
    }

    fun getRealCount(): Int {
        return items.size
    }

    private fun getRealPosition(position: Int): Int {
        return position % items.size
    }

    private fun valueAt(position: Int): LoopTabItem {
        return items[getRealPosition(position)]
    }

    // UnDetachableFragmentPagerAdapter で Fragment の再利用を促すため
    override fun getItemId(position: Int): Long {
        return (getRealPosition(position)).toLong()
    }
}