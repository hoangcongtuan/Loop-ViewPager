package com.nshmura.recyclertablayout

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class ViewHolder<T : ViewBinding>(protected val binding: T) :
    RecyclerView.ViewHolder(binding.root) {
    val view: View
        get() = binding.root
}