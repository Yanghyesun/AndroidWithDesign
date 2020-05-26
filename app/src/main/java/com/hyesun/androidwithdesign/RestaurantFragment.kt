package com.hyesun.androidwithdesign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_restaurant.*

/**
 * A simple [Fragment] subclass.
 */

const val ORDERBYRATE = 1
const val ORDERBYDISTANCE = 2
const val ORDERBYREVIEW = 3

class RestaurantFragment : Fragment() {

    private val rvAdapter by lazy { recyclerShopAdapter(requireContext())}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = mutableListOf<ShopData>()
        data.apply {
            add(ShopData("우동쯔요시",R.drawable.an_list_img_01, false, 4.7.toFloat(), "하남시", 240.toFloat(), "메멜 set, 코돈부르 set", 231,true))
            add(ShopData("빠네렌토", R.drawable.an_list_img_02 ,true, 3.8.toFloat(), "강동구", 2870.toFloat(), "촉촉한 초코칩, 단팥빵", 42))
            add(ShopData("카페수요일",  R.drawable.an_list_img_03_cafe_null, true, 4.0.toFloat(), "하남시", 740.toFloat(), "아이스아메리카노, 카푸치노", 53))
            add(ShopData("소나무집",  R.drawable.an_list_img_04, false, 4.0.toFloat(), "하남시", 300.toFloat(), "오리백숙, 누룽지백숙", 23))
            add(ShopData("유주얼",  R.drawable.an_list_img_05, false, 4.2.toFloat(), "하남시", 40.toFloat(), "바닐라라떼, 쿠키, 초코칩", 82))
            add(ShopData("카페웨더",  R.drawable.an_list_img_06, false, 4.9.toFloat(), "하남시", 2100.toFloat(), "크루와상, 딸기당근케이크", 57,true))
            add(ShopData("긴타코",  R.drawable.an_list_img_07,false, 3.9.toFloat(), "하남시", 990.toFloat(), "매콤 타코야끼, 달달 set", 93))
            add(ShopData("504b로스터리",  R.drawable.an_list_img_08, false, 4.0.toFloat(), "강동구", 4400.toFloat(), "플랫화이트, 수박에이드", 72))
            add(ShopData("계란빵집",  R.drawable.an_list_img_9, true, 3.3.toFloat(), "하남시", 1550.toFloat(), "계란빵", 13))
            add(ShopData("피자집",  R.drawable.an_list_img_10, false, 3.6.toFloat(), "하남시",638.toFloat(), "피자", 10))

        }

        rv_shop.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        rv_shop.addItemDecoration(ShopItemDecoration())
        rv_shop.adapter = rvAdapter
        rv_shop.clipToPadding = true


//        Default is orderbyrate
        tv_orderbyrate.isSelected = true
        rvAdapter.addShop(data.apply { orderShops(ORDERBYRATE) })


        val onClickListener = View.OnClickListener {
            tv_orderbyrate.isSelected = false
            tv_orderbydistance.isSelected = false
            tv_orderbyreview.isSelected = false
            when (it.id) {
                R.id.tv_orderbyrate -> {
                    tv_orderbyrate.isSelected = true
                    data.orderShops(ORDERBYRATE)
                    rvAdapter.replaceShops(data)
                }
                R.id.tv_orderbydistance -> {
                    tv_orderbydistance.isSelected = true
                    data.orderShops(ORDERBYDISTANCE)
                    rvAdapter.replaceShops(data)
                }
                R.id.tv_orderbyreview -> {
                    tv_orderbyreview.isSelected = true
                    data.orderShops(ORDERBYREVIEW)
                    rvAdapter.replaceShops(data)
                }
            }
        }

        tv_orderbyrate.setOnClickListener(onClickListener)
        tv_orderbydistance.setOnClickListener(onClickListener)
        tv_orderbyreview.setOnClickListener(onClickListener)
    }

    fun MutableList<ShopData>.orderShops(option: Int) {
        when (option) {
            ORDERBYRATE -> sortByDescending { it.rate }
            ORDERBYDISTANCE -> sortBy { it.distance }
            ORDERBYREVIEW -> sortByDescending { it.num_review }
        }
    }


}
