package com.hyesun.androidwithdesign
data class ShopResponse(
    val status: Boolean,
    val message: String,
    val data: ShopData
)

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