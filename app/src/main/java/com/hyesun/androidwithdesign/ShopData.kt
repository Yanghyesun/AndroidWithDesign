package com.hyesun.androidwithdesign

import com.google.gson.annotations.SerializedName

data class ShopResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: MutableList<ShopData>
)

data class ShopData(
    var name : String,
    @SerializedName("restaurantIdx")
    var id : Int,
    @SerializedName("img")
    var Image : Int?,
    var scrap : Boolean,
    var rate : Float,
    var location : String,
    var distance : Int,
    var menu : String,
    @SerializedName("numReview")
    var num_review : Int,
    var eatdeal: Boolean = false
)