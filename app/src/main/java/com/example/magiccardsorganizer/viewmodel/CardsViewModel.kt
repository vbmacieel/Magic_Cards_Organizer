package com.example.magiccardsorganizer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.magiccardsorganizer.model.CardsListModel
import com.example.magiccardsorganizer.repository.CardsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardsViewModel(private val cardsRepository: CardsRepository) : ViewModel() {

    private var _cardsList = MutableLiveData<CardsListModel>()
    private var _cardDetails = MutableLiveData<CardsListModel>()
    var errorMessage = MutableLiveData<String>()
    val cardsList: LiveData<CardsListModel> = _cardsList
    val cardDetails: LiveData<CardsListModel> = _cardDetails

    fun getAllCards() {
        val request = cardsRepository.getAllCards()
        request.enqueue(object : Callback<CardsListModel> {
            override fun onResponse(
                call: Call<CardsListModel>,
                response: Response<CardsListModel>
            ) {
                _cardsList.value = response.body()
            }

            override fun onFailure(call: Call<CardsListModel>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getCardDetails(cardId: String) {
        val request = cardsRepository.getCardDetails(cardId)
        request.enqueue(object : Callback<CardsListModel> {
            override fun onResponse(
                call: Call<CardsListModel>,
                response: Response<CardsListModel>
            ) {
                _cardDetails.value = response.body()
            }

            override fun onFailure(call: Call<CardsListModel>, t: Throwable) {
                errorMessage.value = t.message.toString()
            }
        })
    }
}