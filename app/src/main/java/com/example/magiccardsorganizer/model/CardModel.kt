package com.example.magiccardsorganizer.model

import com.google.gson.annotations.SerializedName

data class CardModel (
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("imageUrl") val imageUrl: String
    )
