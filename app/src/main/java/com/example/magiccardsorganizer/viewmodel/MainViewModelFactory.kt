package com.example.magiccardsorganizer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.magiccardsorganizer.repository.CardsRepository
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val repository: CardsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CardsViewModel::class.java)) {
            CardsViewModel(repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found !")
        }
    }
}