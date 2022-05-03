package com.example.magiccardsorganizer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.magiccardsorganizer.R
import com.example.magiccardsorganizer.databinding.CardItemLayoutBinding
import com.example.magiccardsorganizer.databinding.CardsFragmentBinding
import com.example.magiccardsorganizer.model.CardModel
import com.example.magiccardsorganizer.model.CardsListModel
import com.example.magiccardsorganizer.ui.fragments.CardsFragment

class CardsRecyclerView(
    private val cardsList: CardsListModel
) : RecyclerView.Adapter<CardsRecyclerView.CardsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder =
        CardsViewHolder(CardItemLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        val cardItem: CardModel = cardsList.cards[position]
        holder.bind(cardItem)
    }

    override fun getItemCount(): Int = cardsList.cards.size

    inner class CardsViewHolder(private val binding: CardItemLayoutBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(card: CardModel) {
            binding.apply {
                Glide.with(binding.root).load(card.imageUrl)
                    .into(this.cardImage)
                cardName.text = card.name
            }
        }
    }
}