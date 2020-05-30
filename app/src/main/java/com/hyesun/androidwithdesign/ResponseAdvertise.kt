package com.hyesun.androidwithdesign

data class ResponseAdvertise(
    val status: Int,
    val success: Boolean,
    val data: AdvertiseData
)
data class AdvertiseData(
    val index: Int,
    val img_url: String
)