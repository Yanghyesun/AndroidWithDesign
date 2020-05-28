package com.hyesun.androidwithdesign

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MangoPagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> EatdealFragment().newInstance()
            1 -> MpickstoryFragment().newInstance()
            else -> ToplistFragment().newInstance()
        }
    }

    override fun getCount() = 3
}