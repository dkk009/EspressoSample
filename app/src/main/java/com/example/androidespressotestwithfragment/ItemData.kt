package com.example.androidespressotestwithfragment

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ItemData(val itemNUmber: Int, val itemDescription: String) : Parcelable