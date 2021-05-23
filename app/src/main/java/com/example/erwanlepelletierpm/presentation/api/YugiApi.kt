package com.example.erwanlepelletierpm.presentation.api

import retrofit2.Call
import retrofit2.http.GET


interface YugiApi {
    @GET("cardinfo.php")
    fun getYugiList(): Call<YugiohResponse>

}