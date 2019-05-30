package com.flores.listrxjavaandroid.data.api

import com.flores.listrxjavaandroid.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit2ApiManager {

    private var retrofit2Api: Retrofit2Api? = null

    fun processApi(): Retrofit2Api? {
        if (retrofit2Api == null) {

            val interceptor = HttpLoggingInterceptor()

            interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE

            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/discover/")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build()

            retrofit2Api = retrofit.create(Retrofit2Api::class.java)
        }
        return retrofit2Api
    }
}