package com.hyesun.androidwithdesign

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){
    class FragmentInfo(val titleText: String, val fragment: Fragment)

    private val mFragmentInfoList = ArrayList<FragmentInfo>()

    fun addFragment(title: String, fragment:Fragment){
        val info = FragmentInfo(title,fragment)
        mFragmentInfoList.add(info)
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentInfoList[position].fragment
    }

    override fun getCount(): Int {
        return mFragmentInfoList.size // return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mFragmentInfoList[position].titleText
    }
}
