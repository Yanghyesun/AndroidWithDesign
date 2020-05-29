package com.hyesun.androidwithdesign

import android.graphics.drawable.Drawable

data class EatdealData (
    var scrap : Boolean,
    val percent : String,
    val name : String,
    val menu : String,
    val region : String,
    val origin_price : String,
    val discount_price : String,
    val img_contents : Int
)