package com.flores.listrxjavaandroid.data.repository

import com.flores.listrxjavaandroid.data.datasource.remote.MovieDataSource
import com.flores.listrxjavaandroid.domain.entity.MovieResult
import io.reactivex.Single

class MovieRepositoryImpl(private val employeeDataSource: MovieDataSource) : MovieRepository {

    override fun getEmployee(page: Int): Single<MovieResult> {
        return employeeDataSource.getListMovies(page)
    }

}