package com.example.androidespressotestwithfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(
    private val itemList: List<ItemData>,
    private val callbackMethod: (ItemData, Int, String) -> Unit
) : RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewHolder = ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_viewholder,
                parent,
                false
            ), callBackMethod = callbackMethod
        )
        return viewHolder
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindData(itemList[position])
    }
}