package com.example.magiccardsorganizer.model

import com.google.gson.annotations.SerializedName

data class CardModel (
    @SerializedName("name") val name: String,
    @SerializedName("manaCost") val manaCost: String,
    @SerializedName("type") val type: String,
    @SerializedName("rarity") val rarity: String
    )
