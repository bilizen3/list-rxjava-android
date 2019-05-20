package com.flores.listrxjavaandroid.data.api

import com.flores.listrxjavaandroid.data.model.Employee
import retrofit2.http.GET



interface Retrofit2Api {

    @GET("employees")
    fun getCountry(): retrofit2.Call<List<Employee>>

}