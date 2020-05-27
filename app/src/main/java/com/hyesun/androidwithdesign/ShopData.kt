package com.hyesun.androidwithdesign

import android.net.Uri

data class ShopData(
    var name : String,
    var Image : Int?,
    var scrap : Boolean,
    var rate : Float,
    var location : String,
    var distance : Float,
    var menu : String,
    var num_review : Int,
    var eatdeal: Boolean = false
)