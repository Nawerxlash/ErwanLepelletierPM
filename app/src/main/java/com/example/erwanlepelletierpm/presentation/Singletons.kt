package com.example.erwanlepelletierpm.presentation

import com.example.erwanlepelletierpm.presentation.api.YugiApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Singletons {
    companion object {

        /*var cache = Cache(File(context?.cacheDir,"responses"),10 * 1024 * 1024)

        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache)
            .build()*/

         val yugiApi: YugiApi = Retrofit.Builder()
                .baseUrl("https://db.ygoprodeck.com/api/v7/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(YugiApi::class.java)
    }
}