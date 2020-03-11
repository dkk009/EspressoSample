package com.example.androidespressotestwithfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment(R.layout.fragment_list) {

    private val itemList = ArrayList<ItemData>()
    private val listAdapter = ListAdapter(itemList, ::handleItemClick)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemList.addAll(ItemDataUtil.getSampleData())
        rvItemList.adapter = listAdapter
        rvItemList.layoutManager = LinearLayoutManager(activity)

    }

    private fun handleItemClick(itemData: ItemData, pos: Int, tag: String) {
        val fragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putParcelable("data", itemData)
        fragment.arguments = bundle
        if (activity is MainActivity) {
            (activity as MainActivity).replaceFragment(fragment, isAddToBackStack = true)
        }
    }
}