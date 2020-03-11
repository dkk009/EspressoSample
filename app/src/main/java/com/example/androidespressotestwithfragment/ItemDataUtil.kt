package com.example.androidespressotestwithfragment

object ItemDataUtil {
    fun getSampleData(): List<ItemData> {
        val itemList = ArrayList<ItemData>()
        for (index in 0 until 100) {
            itemList.add(ItemData(index + 1, "Item Description for${index + 1}"))
        }
        return itemList
    }
}