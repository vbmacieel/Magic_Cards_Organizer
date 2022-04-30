package com.example.magiccardsorganizer.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.magiccardsorganizer.R
import com.example.magiccardsorganizer.databinding.DecksFragmentBinding

class DecksFragment : Fragment(R.layout.decks_fragment){

    private lateinit var binding: DecksFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DecksFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}