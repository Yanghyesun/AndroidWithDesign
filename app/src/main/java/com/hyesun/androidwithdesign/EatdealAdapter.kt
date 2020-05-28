package com.hyesun.androidwithdesign

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EatdealAdapter(private val context : Context) : RecyclerView.Adapter<EatdealViewHolder>() {

    var datas : MutableList<EatdealData> = mutableListOf<EatdealData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EatdealViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_eatdeal, parent, false)
        return EatdealViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: EatdealViewHolder, position: Int) {
        holder.bind(datas[position])
    }
}