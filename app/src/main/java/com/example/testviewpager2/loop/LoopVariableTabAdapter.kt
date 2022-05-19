package com.example.testviewpager2.loop

import android.content.Context
import androidx.viewpager.widget.ViewPager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.testviewpager2.R
import com.nshmura.recyclertablayout.LoopPagerAdapter
import com.nshmura.recyclertablayout.LoopTabHolder
import com.nshmura.recyclertablayout.RecyclerTabLayout
import com.nshmura.recyclertablayout.ViewPagerCustom1

/**
 * RecyclerTabLayout で利用する 枠の幅が可変の PagerAdapter
 */
class LoopVariableTabAdapter(
    val context: Context,
    viewPager: ViewPagerCustom1
) : RecyclerTabLayout.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>(viewPager) {
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LoopTabHolder.VariableLoopTabViewHolder(inflater, parent, false)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val adapter = viewPager.adapter as LoopPagerAdapter? ?: return
        when (holder) {
            is LoopTabHolder.VariableLoopTabViewHolder -> {
                val selected = (position % adapter.getRealCount()) == (currentIndicatorPosition % adapter.getRealCount())
                holder.bind(
                    selected,
                    adapter.getPageTitle(position).toString(),
                )
            }
        }
        holder.itemView.setOnClickListener {
            viewPager.setCurrentItem(position, false)
        }
    }

    override fun getItemCount(): Int {
        val adapter = viewPager.adapter ?: return 0
        return adapter.count
    }

    private fun formatBadge(badge: Int): String? {
        return when (badge) {
            0 -> return null
            in 1..99 -> badge.toString()
            else -> context.getString(R.string.max_number_of_badges) // 100以上は 99+ という表記にする
        }
    }

}
