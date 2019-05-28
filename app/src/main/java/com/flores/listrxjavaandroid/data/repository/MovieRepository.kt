package com.flores.listrxjavaandroid.data.repository

import com.flores.listrxjavaandroid.domain.entity.MovieResult
import io.reactivex.Single

interface MovieRepository {

    fun getEmployee(page: Int): Single<MovieResult>

}