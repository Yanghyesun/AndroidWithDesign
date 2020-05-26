package com.hyesun.androidwithdesign

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShopItemDecoration (val devicex : Int) : RecyclerView.ItemDecoration(){

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)


        val position = parent.getChildAdapterPosition(view)
        val span = (view.layoutParams as GridLayoutManager.LayoutParams).spanIndex

//      layout과 layout사이의 간격
        val basis = (devicex*0.044).toInt()

        if (position ==0 || position ==1){
            outRect.top = basis
            outRect.bottom = basis
        } else {
            outRect.bottom = basis
        }

        if (span == 0){
            outRect.left = basis
            outRect.right = basis/2
        } else{
            outRect.left = basis/2
            outRect.right = basis
        }

    }
}