package com.example.magiccardsorganizer.model

import com.google.gson.annotations.SerializedName

data class CardsListModel (
    @SerializedName("cards") val cards: MutableList<CardModel>,
    @SerializedName("card") val card: CardDetailModel
)