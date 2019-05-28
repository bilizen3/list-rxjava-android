package com.flores.listrxjavaandroid.data.repository

import com.flores.listrxjavaandroid.domain.entity.Movie
import io.reactivex.Single

interface MovieRepository {
    fun getEmployee(): Single<List<Movie>>
}