package com.example.magiccardsorganizer.api

import com.example.magiccardsorganizer.model.CardsListModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    companion object {
        private val retrofitService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.magicthegathering.io/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(RetrofitService::class.java)
        }
        fun getInstance(): RetrofitService = retrofitService
    }

    @GET("cards")
    fun getAllCards(): Call<CardsListModel>

    @GET("cards/{id}")
    fun getCardDetail(@Path("id") cardId: String): Call<CardsListModel>
}