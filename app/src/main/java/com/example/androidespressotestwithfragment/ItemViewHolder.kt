package com.example.androidespressotestwithfragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_viewholder.view.*

class ItemViewHolder(view: View, private val callBackMethod: (ItemData, Int, String) -> Unit) :
    RecyclerView.ViewHolder(view) {

    init {
        itemView.setOnClickListener {
            val data = itemView.tag as ItemData
            callBackMethod(data, adapterPosition, "ItemClick")
        }
    }

    fun bindData(itemData: ItemData) {
        itemView.tag = itemData
        itemView.txtItemNumber.text = itemData.itemNUmber.toString()
        itemView.txtItemDescription.text = itemData.itemDescription
    }

}