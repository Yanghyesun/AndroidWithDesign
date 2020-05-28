package com.hyesun.androidwithdesign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_mango.*


/**
 * A simple [Fragment] subclass.
 */

class MangoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mango, container, false)

        /*val myContext: FragmentActivity
        fun onAttach(activity: Activity) {
            myContext = activity as FragmentActivity
            super.onAttach(activity)
        }

        tab_viewPager.adapter = MangoPagerAdapter(myContext.supportFragmentManager)
        tab_viewPager.offscreenPageLimit = 2

        tabLayout.setupWithViewPager(tab_viewPager)*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentAdapter = PagerAdapter(getActivity()!!.supportFragmentManager)
        fragmentAdapter.addFragment("EAT딜",EatdealFragment())
        fragmentAdapter.addFragment("망고픽 스토리",MpickstoryFragment())
        fragmentAdapter.addFragment("TOP 리스트",ToplistFragment())
        viewpager_main.adapter = fragmentAdapter

        viewpager_main.addOnPageChangeListener( TabLayout.TabLayoutOnPageChangeListener(tabs_main))
        tabs_main.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) { }
            override fun onTabUnselected(tab: TabLayout.Tab) { }
            override fun onTabReselected(tab: TabLayout.Tab) { }
        })
        tabs_main.setupWithViewPager(viewpager_main)
    }
}

