package com.example.myapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val name: String,
    val description : String,
    val photo: Int
):Parcelable
