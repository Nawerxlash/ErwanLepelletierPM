package com.example.erwanlepelletierpm.presentation

import com.example.erwanlepelletierpm.presentation.api.YugiApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Singletons {
    companion object {
         val yugiApi: YugiApi = Retrofit.Builder()
                .baseUrl("https://db.ygoprodeck.com/api/v7/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(YugiApi::class.java)
    }
}