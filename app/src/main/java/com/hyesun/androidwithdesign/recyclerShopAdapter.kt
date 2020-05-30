package com.hyesun.androidwithdesign

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val MIN_NUM = 30

class recyclerShopAdapter(private val context: Context, private val standardx : Int) :
    RecyclerView.Adapter<recyclerShopAdapter.VHolder>() {


    private val shopList = mutableListOf<ShopData>()

    @Suppress("UNCHECKED_CAST")
    fun addShop(item: Any) {
        when (item) {
            is ShopData -> shopList.add(item)
            is MutableList<*> -> shopList.addAll(item as MutableList<ShopData>)
        }
        notifyDataSetChanged()
    }

    fun replaceShops(list : MutableList<ShopData>){
        shopList.clear()
        shopList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        return VHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_shop, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.setHolder(shopList[position], position, context, standardx)

    }


    class VHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val shopImage = itemView.findViewById<ImageView>(R.id.iv_shop)
        private val scrapimage = itemView.findViewById<ImageView>(R.id.iv_scrap)
        private val name = itemView.findViewById<TextView>(R.id.tv_rankandname)
        private val location = itemView.findViewById<TextView>(R.id.tv_location)
        private val distance = itemView.findViewById<TextView>(R.id.tv_distance)
        private val menu = itemView.findViewById<TextView>(R.id.tv_menu)
        private val star = itemView.findViewById<ImageView>(R.id.iv_star)
        private val rate = itemView.findViewById<TextView>(R.id.tv_rate)
        private val eatdeal = itemView.findViewById<ImageView>(R.id.iv_eatdeal)

        fun setHolder(item: ShopData, position: Int, context: Context, standardx: Int) {

            val layoutParams = itemView.layoutParams
            layoutParams.width = (standardx* 0.433).toInt()
            layoutParams.height = (standardx*0.563).toInt()

            Glide.with(itemView).load(item.Image).error(R.drawable.ic_launcher_background)
                .into(shopImage)
            scrapimage.isSelected = item.scrap
            name.text = context.getString(R.string.rankandname, position + 1, item.name)
            location.text = item.location
            distance.text = convertDistance(item.distance)
            menu.text = item.menu
            rate.text = item.rate.toString()

            if (item.eatdeal){
                eatdeal.visibility = View.VISIBLE
            } else{
                eatdeal.visibility = View.GONE
            }

            if (item.num_review > MIN_NUM) {
                rate.setTextColor(ContextCompat.getColor(context, R.color.colorOver4))
                Glide.with(itemView).load(R.drawable.an_ic_grade_over4).into(star)
            } else {
                rate.setTextColor(ContextCompat.getColor(context, R.color.colorUnder4))
                Glide.with(itemView).load(R.drawable.an_ic_grade_under4).into(star)
            }

            scrapimage.setOnClickListener {
//                state 바꿔서 색깔 바꾸고, 데이터도 바꾸기
                if (it.isSelected) {
                    it.isSelected= false
                    item.scrap = false
                } else if (!it.isSelected) {
                    it.isSelected = true
                    item.scrap = true
                }

            }
        }
        private fun convertDistance(distance : Float): String{
            if (distance > 1000){
                return (distance/1000).toString()+"km"
            } else {
                return distance.toInt().toString()+"m"
            }
        }
    }
}