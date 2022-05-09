package com.example.magiccardsorganizer.ui.dialog

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.magiccardsorganizer.R
import com.example.magiccardsorganizer.api.RetrofitService
import com.example.magiccardsorganizer.databinding.CardDetailDialogLayoutBinding
import com.example.magiccardsorganizer.model.CardDetailModel
import com.example.magiccardsorganizer.repository.CardsRepository
import com.example.magiccardsorganizer.viewmodel.CardsViewModel
import com.example.magiccardsorganizer.viewmodel.MainViewModelFactory

class CardDetailsDialog(private val cardId: String) : DialogFragment() {

    private lateinit var mBinding: CardDetailDialogLayoutBinding
    private lateinit var mCardsViewModel: CardsViewModel
    private lateinit var mRetrofitService: RetrofitService.Companion

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = CardDetailDialogLayoutBinding.inflate(layoutInflater, container, false)
        setViewModel()
        mCardsViewModel.getCardDetails(cardId)
        AlertDialog.Builder(mBinding.root.context)
            .setView(inflater.inflate(R.layout.card_detail_dialog_layout, mBinding.root))
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        mCardsViewModel.cardDetails.observe(this) { cardDetails ->
            bindViewItems(cardDetails.card)
        }
    }

    private fun bindViewItems(cardDetails: CardDetailModel) {
        mBinding.apply {
            Glide.with(root).load(cardDetails.imageUrl).into(cardDetailImage)
            cardDetailName.text = cardDetails.name
            cardDetailRarity.text = cardDetails.rarity
            cardDetailType.text = cardDetails.type
            cardDetailDescription.text = cardDetails.description
        }
    }

    private fun setViewModel() {
        mRetrofitService = RetrofitService
        mCardsViewModel = ViewModelProvider(this, MainViewModelFactory(
            CardsRepository(mRetrofitService.getInstance())))
            .get(CardsViewModel::class.java)
    }
}