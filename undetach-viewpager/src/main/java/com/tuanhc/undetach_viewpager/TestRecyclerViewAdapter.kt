package com.tuanhc.undetach_viewpager

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TestRecyclerViewAdapter: RecyclerView.Adapter<TestRecyclerViewAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestRecyclerViewAdapter.VH {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TestRecyclerViewAdapter.VH, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class VH(view: View): RecyclerView.ViewHolder(view) {
        private fun bind(title: String) {

        }
    }
}