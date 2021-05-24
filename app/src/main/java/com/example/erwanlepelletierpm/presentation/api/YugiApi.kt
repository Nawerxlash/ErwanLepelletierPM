package com.example.erwanlepelletierpm.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface YugiApi {
    @GET("cardinfo.php")
    fun getYugiList(): Call<YugiohResponse>

    @GET("cardinfo.php/{{id}}")
    fun getYugiDetail(@Path("id") id: Int): Call<YugiohDetailResponse>

}