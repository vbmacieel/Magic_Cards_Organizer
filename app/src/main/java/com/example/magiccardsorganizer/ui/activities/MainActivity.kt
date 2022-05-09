package com.example.magiccardsorganizer.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.magiccardsorganizer.R
import com.example.magiccardsorganizer.databinding.ActivityMainBinding
import com.example.magiccardsorganizer.ui.fragments.CardsFragment
import com.example.magiccardsorganizer.ui.fragments.DecksFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setUpNavigationBottomMenu()
        setFragment(DecksFragment(), "Decks")
    }

    private fun setUpNavigationBottomMenu() {
        mBinding.bottomNavigationMenu.setOnItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.decks -> {
                    val decksFragment = DecksFragment()
                    setFragment(decksFragment, "Decks")
                }
                R.id.cards -> {
                    val cardsFragment = CardsFragment()
                    setFragment(cardsFragment, "Cards")
                }
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment, title: String) {
        setAppTitle(title)
        supportFragmentManager.beginTransaction()
            .replace(R.id.framelayout_fragment, fragment)
            .commit()
    }

    private fun setAppTitle(title: String) {
        supportActionBar!!.title = title
    }
}