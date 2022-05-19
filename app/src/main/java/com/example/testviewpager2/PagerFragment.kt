package com.example.testviewpager2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.SparseLongArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testviewpager2.databinding.PagerFragmentBinding

class PagerFragment : Fragment() {
    lateinit var binding: PagerFragmentBinding
    private lateinit var title: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        title = arguments?.getString(KEY_TITLE)?: "null"
        Log.d(TAG, "onAttach: $title")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach: $title")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: $title")
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*return super.onCreateView(inflater, container, savedInstanceState)*/
        binding = PagerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView.text = arguments?.getString(KEY_TITLE)
        Log.d(TAG, "onViewCreated: $title")
    }

    companion object {
        private const val KEY_TITLE = "key_title"
        private const val TAG = "PagerFragment"
        fun newInstance(title: String): PagerFragment {
            return PagerFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_TITLE, title)
                }
            }
        }
    }
}