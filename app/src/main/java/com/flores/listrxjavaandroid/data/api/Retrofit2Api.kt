package com.flores.listrxjavaandroid.data.api

import com.flores.listrxjavaandroid.data.entity.response.MovieResultResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Retrofit2Api {

    @GET("movie")
    fun getListMovies(
        @Query("page") page : Int,
        @Query("api_key") api_key : String
    ): Single<MovieResultResponse>

}