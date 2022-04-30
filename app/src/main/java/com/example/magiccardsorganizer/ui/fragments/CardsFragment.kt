package com.example.magiccardsorganizer.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.magiccardsorganizer.R
import com.example.magiccardsorganizer.databinding.CardsFragmentBinding

class CardsFragment : Fragment(R.layout.cards_fragment){

    private lateinit var binding: CardsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CardsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}