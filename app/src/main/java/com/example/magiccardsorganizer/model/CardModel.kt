package com.example.magiccardsorganizer.model

import com.google.gson.annotations.SerializedName

data class CardModel (
    @SerializedName("name") val name: String,
    @SerializedName("imageUrl") val imageUrl: String,
    )
