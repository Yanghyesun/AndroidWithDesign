package com.hyesun.androidwithdesign

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class EatdealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val img_contents = itemView.findViewById<ImageView>(R.id.img_contents)
    val tv_percent = itemView.findViewById<TextView>(R.id.tv_percent)
    val tv_name = itemView.findViewById<TextView>(R.id.tv_name)
    val tv_region = itemView.findViewById<TextView>(R.id.tv_region)
    val tv_menu = itemView.findViewById<TextView>(R.id.tv_menu)
    val tv_originPrice = itemView.findViewById<TextView>(R.id.tv_originPrice)
    val tv_discountPrice = itemView.findViewById<TextView>(R.id.tv_discountPrice)


    fun bind(eatdealData : EatdealData) {
        tv_percent.text = eatdealData.percent
        tv_name.text = eatdealData.name
        tv_region.text = eatdealData.region
        tv_menu.text = eatdealData.menu
        tv_originPrice.text = eatdealData.origin_price
        tv_discountPrice.text = eatdealData.discount_price
        Glide.with(itemView).load(eatdealData.img_contents).into(img_contents)
    }
}