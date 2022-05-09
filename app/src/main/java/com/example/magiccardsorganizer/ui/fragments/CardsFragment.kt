package com.example.magiccardsorganizer.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.magiccardsorganizer.R
import com.example.magiccardsorganizer.adapter.CardsRecyclerView
import com.example.magiccardsorganizer.api.RetrofitService
import com.example.magiccardsorganizer.databinding.CardsFragmentBinding
import com.example.magiccardsorganizer.model.CardsListModel
import com.example.magiccardsorganizer.repository.CardsRepository
import com.example.magiccardsorganizer.ui.dialog.CardDetailsDialog
import com.example.magiccardsorganizer.viewmodel.CardsViewModel
import com.example.magiccardsorganizer.viewmodel.MainViewModelFactory

class CardsFragment : Fragment(R.layout.cards_fragment), CardsRecyclerView.OnCardClickListener{

    private lateinit var mBinding: CardsFragmentBinding
    private lateinit var mRetrofitService: RetrofitService.Companion
    private lateinit var mCardsViewModel: CardsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = CardsFragmentBinding.inflate(inflater, container, false)
        mCardsViewModel.getAllCards()
        return mBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setViewModel()
        mCardsViewModel.cardsList.observe(this) { cardsListModel ->
            setRecyclerView(cardsListModel)
        }
    }

    private fun setRecyclerView(cardsListModel: CardsListModel) {
        val cardsRecyclerViewAdapter = CardsRecyclerView(cardsListModel, this)
        mBinding.recyclerviewCards.layoutManager = GridLayoutManager(view?.context, 2)
        mBinding.recyclerviewCards.adapter = cardsRecyclerViewAdapter
    }

    override fun onCardClick(position: Int, id: String) {
        val cardDetailsDialog = CardDetailsDialog(id)
        cardDetailsDialog.show(requireActivity()
            .supportFragmentManager, "Card dialog fragment")
    }

    private fun setViewModel() {
        mRetrofitService = RetrofitService
        mCardsViewModel = ViewModelProvider(this, MainViewModelFactory(
                CardsRepository(mRetrofitService.getInstance())))
            .get(CardsViewModel::class.java)
    }
}