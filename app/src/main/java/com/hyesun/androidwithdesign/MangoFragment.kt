package com.hyesun.androidwithdesign

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_mango.*

/**
 * A simple [Fragment] subclass.
 */

class MangoFragment : Fragment() {

    lateinit var eatdealAdapter: EatdealAdapter
    lateinit var layoutManager: LinearLayoutManager
    val datas : MutableList<EatdealData> = mutableListOf<EatdealData>()

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
        initRcv(view)
        loadDatas()
        //데이터를 임의로 생성하고 어댑터에 전달해주겠습니다!
    }

    private fun initRcv(view : View) {
        eatdealAdapter = EatdealAdapter(view.context)
        rv_eatdeal.adapter = eatdealAdapter
        //recyclerView의 어댑터를 instaAdapter로 지정
        rv_eatdeal.apply {
            layoutManager = LinearLayoutManager(view.context)
            addItemDecoration(EatdealItemDecoration(view.context))
        }
    }

    private fun loadDatas() {
        datas.apply {
            add(EatdealData(
                    percent = "15%",
                    name = "탐복 현대백화점 신촌점",
                    menu = "구이반상",
                    region = "신촌",
                    origin_price = "￦26,000",
                    discount_price = "￦22,000",
                    img_contents = R.drawable.an_mdeal_img_01
            ))

            add(EatdealData(
                    percent = "31%",
                    name = "비밀시그니쳐 현대백화...",
                    menu = "고르곤졸라 피자",
                    region = "신촌",
                    origin_price = "￦13,000",
                    discount_price = "￦9,000",
                    img_contents = R.drawable.an_mdeal_img_02
            ))

            add(EatdealData(
                    percent = "31%",
                    name = "비밀시그니쳐 현대백화...",
                    menu = "까르보나라",
                    region = "신촌",
                    origin_price = "￦13,000",
                    discount_price = "￦9,000",
                    img_contents = R.drawable.an_mdeal_img_03
            ))

            add(EatdealData(
                    percent = "29%",
                    name = "송 현대백화점 신촌점",
                    menu = "쟁반 메밀정식",
                    region = "신촌",
                    origin_price = "￦14,000",
                    discount_price = "￦10,000",
                    img_contents = R.drawable.an_mdeal_img_04
            ))

            add(EatdealData(
                    percent = "24%",
                    name = "정육점 불고기 현대백화...",
                    menu = "한우불고기 솥밥 세트",
                    region = "신촌",
                    origin_price = "￦25,000",
                    discount_price = "￦19,000",
                    img_contents = R.drawable.an_mdeal_img_05
            ))
        }
        //AndroidMenifest.xml에서 uses-permission INTERNET 설정을 해줘야만 이미지 로드 가능

        eatdealAdapter.datas = datas
        eatdealAdapter.notifyDataSetChanged()
        //데이터가 갱신되었음을 Adapter에게 알려주는 역할
    }
}

