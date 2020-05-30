package com.hyesun.androidwithdesign

import retrofit2.Call
import retrofit2.http.POST

interface RequestInterface {

    @POST
    fun loadShop() : Call<ShopResponse>


}