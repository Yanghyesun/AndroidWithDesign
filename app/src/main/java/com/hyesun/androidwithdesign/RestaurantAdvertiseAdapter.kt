package com.hyesun.androidwithdesign

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class RestaurantAdvertiseAdapter(fm: FragmentManager, private val page_count: Int) : FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        val adverFragment = AdvertiseFragment()
        val bundle = Bundle(page_count)
        bundle.putInt("id",position)
        adverFragment.arguments = bundle
        return adverFragment
    }

    override fun getCount(): Int = page_count
}