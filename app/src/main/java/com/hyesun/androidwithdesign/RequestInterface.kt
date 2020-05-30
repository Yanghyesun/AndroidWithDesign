package com.hyesun.androidwithdesign

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface RequestInterface {

    @POST
    fun loadShop() : Call<ShopResponse>

    //광고 띄우기
    @GET("/restaurant/ad")
    fun requestAdvertise(

    ):Call<ResponseAdvertise>

    //eatdeal 화면 목록
    @GET("/eatdeal")
    fun requestEatdeal(

    ):Call<ResponseEatdeal>

    //eatdeal- scrap
    @GET("/eatdeal/scrap")
    fun requestEatDealScrap(

    ):Call<ResponseEatdealScrap>
}