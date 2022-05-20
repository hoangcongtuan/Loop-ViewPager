package com.tuanhc.undetach_viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

public abstract class LoopFragmentStateAdapter<T>(private val fa: FragmentActivity) :
    UnDetachFragmentStateAdapter(fa) {

    private val items: MutableList<T> = mutableListOf()

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun ensureFragment(position: Int) {
        /*super.ensureFragment(position)*/
        val realPosition = getRealPosition(position)
        val realItemId = getItemId(realPosition)
        if (!mFragments.containsKey(realItemId)) {
            // TODO(133419201): check if a Fragment provided here is a new Fragment
            val newFragment = createFragment(position)
            newFragment.setInitialSavedState(mSavedStates[realItemId])
            mFragments.put(realItemId, newFragment)
        }
    }

    override fun getFragmentOfViewHolder(holder: com.example.customviewpager2.FragmentViewHolder): Fragment {
        val position = getRealPosition(holder.adapterPosition)
        val itemId = getItemId(position)
        return mFragments.get(itemId)!!
    }

    public fun submitList(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    private fun getRealCount() = items.size

    private fun getRealPosition(position: Int) = position % items.size

    private fun getItemAt(position: Int): T {
        return items[getRealPosition(position)]
    }

    override fun onBindViewHolder(
        holder: com.example.customviewpager2.FragmentViewHolder,
        position: Int
    ) {
        super.onBindViewHolder(holder, getRealPosition(position))
    }
}