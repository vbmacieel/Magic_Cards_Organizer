package com.example.magiccardsorganizer.model

import com.google.gson.annotations.SerializedName

data class CardDetailModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("type") val type: String,
    @SerializedName("rarity") val rarity: String,
    @SerializedName("text") val description: String,
)
