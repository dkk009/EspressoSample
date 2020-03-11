package com.example.androidespressotestwithfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment(R.layout.fragment_details) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<ItemData>("data")?.let {
            txtItem.text = it.itemDescription
        }
        btnOk.setOnClickListener {
            activity?.onBackPressed()
        }
    }
}