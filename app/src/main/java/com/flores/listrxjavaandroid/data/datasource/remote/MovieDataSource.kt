package com.flores.listrxjavaandroid.data.datasource.remote

import com.flores.listrxjavaandroid.domain.entity.MovieResult
import io.reactivex.Single

interface MovieDataSource {

    fun getListMovies(page: Int): Single<MovieResult>

}