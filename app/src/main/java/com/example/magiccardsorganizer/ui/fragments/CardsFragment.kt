package com.example.magiccardsorganizer.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.magiccardsorganizer.R
import com.example.magiccardsorganizer.adapter.CardsRecyclerView
import com.example.magiccardsorganizer.api.RetrofitService
import com.example.magiccardsorganizer.databinding.CardsFragmentBinding
import com.example.magiccardsorganizer.model.CardsListModel
import com.example.magiccardsorganizer.repository.CardsRepository
import com.example.magiccardsorganizer.viewmodel.CardsViewModel
import com.example.magiccardsorganizer.viewmodel.MainViewModelFactory

class CardsFragment : Fragment(R.layout.cards_fragment){

    private lateinit var binding: CardsFragmentBinding
    private lateinit var retrofitService: RetrofitService.Companion
    private lateinit var cardsViewModel: CardsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CardsFragmentBinding.inflate(inflater, container, false)
        cardsViewModel.getAllCards()
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setViewModel()
        cardsViewModel.cardsList.observe(this) { cardsListModel ->
            setRecyclerView(cardsListModel)
        }
    }

    private fun setRecyclerView(cardsListModel: CardsListModel) {
        val cardsRecyclerViewAdapter = CardsRecyclerView(cardsListModel)
        binding.recyclerviewCards.layoutManager = GridLayoutManager(view?.context, 2)
        binding.recyclerviewCards.adapter = cardsRecyclerViewAdapter
    }

    private fun setViewModel() {
        retrofitService = RetrofitService
        cardsViewModel = ViewModelProvider(this, MainViewModelFactory(
                CardsRepository(retrofitService.getInstance())))
            .get(CardsViewModel::class.java)
    }
}