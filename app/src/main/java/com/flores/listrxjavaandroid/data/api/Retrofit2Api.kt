package com.flores.listrxjavaandroid.data.api

import com.flores.listrxjavaandroid.data.model.EmployeeResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface Retrofit2Api {

    @GET("employees")
    fun getEmployees(): Single<List<EmployeeResponse>>

}