package com.flores.listrxjavaandroid.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit2ApiManager {
    private var retrofit2Api: Retrofit2Api? = null

    fun processApi(): Retrofit2Api? {
        if (retrofit2Api == null) {
            val retrofit = Retrofit.Builder().baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create()).build()
            retrofit2Api = retrofit.create(Retrofit2Api::class.java)
        }
        return retrofit2Api
    }
}