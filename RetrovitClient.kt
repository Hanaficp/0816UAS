package com.Hanafi.github.ui.main.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrovitClient {
    private const val  BASE_URL = "https://api.github.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiInstance = retrofit.create(Api::class.java)
}