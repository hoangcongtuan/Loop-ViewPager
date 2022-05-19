package com.nshmura.recyclertablayout

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.nshmura.recyclertablayout.databinding.ViewLoopTabLayoutBinding

sealed class LoopTabHolder<T : ViewBinding>(binding: T) : ViewHolder<T>(binding) {

    class LoopTabViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        root: Boolean
    ) : LoopTabHolder<ViewLoopTabLayoutBinding>(
        ViewLoopTabLayoutBinding.inflate(inflater, parent, root)
    ) {
        fun bind(selected: Boolean, title: String, imageResId: Int, badge: String? = null) {
            binding.apply {
                textView.text = title
                textView.setTextColor(if (selected) Color.BLACK else Color.WHITE)
                textView.setBackgroundColor(if (selected) Color.WHITE else Color.BLACK)
            }
        }
    }

    class VariableLoopTabViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        root: Boolean
    ) : LoopTabHolder<ViewLoopTabLayoutBinding>(
        ViewLoopTabLayoutBinding.inflate(inflater, parent, root)
    ) {
        fun bind(selected: Boolean, title: String) {
            binding.apply {
                textView.text = title
                textView.setTextColor(if (selected) Color.BLACK else Color.WHITE)
                textView.setBackgroundColor(if (selected) Color.WHITE else Color.BLACK)
            }
        }
    }
}
