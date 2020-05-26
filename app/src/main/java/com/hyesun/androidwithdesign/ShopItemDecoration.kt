package com.hyesun.androidwithdesign

import android.graphics.Rect
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShopItemDecoration () : RecyclerView.ItemDecoration(){

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
        val basis = 16
//      layout안에서의 padding 간격
        val basis_padding = 30

        if (position ==0 || position ==1){
            outRect.top = basis
            outRect.bottom = basis
        } else {
            outRect.bottom = basis
        }

        if (span == 0){
            outRect.left = basis
            outRect.right = basis/2
            view.findViewById<ConstraintLayout>(R.id.layout_shop).setPadding(basis_padding,0,0,0)
        } else{
            outRect.left = basis/2
            outRect.right = basis
            view.findViewById<ConstraintLayout>(R.id.layout_shop).setPadding(0,0,basis_padding,0)
        }

    }
}