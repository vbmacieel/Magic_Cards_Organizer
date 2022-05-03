package com.example.magiccardsorganizer.repository

import com.example.magiccardsorganizer.api.RetrofitService

class CardsRepository(private val retrofitService: RetrofitService) {
    fun getAllCards() = retrofitService.getAllCards()
}