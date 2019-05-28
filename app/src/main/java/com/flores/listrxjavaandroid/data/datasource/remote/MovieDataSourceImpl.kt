package com.flores.listrxjavaandroid.data.datasource.remote

import com.flores.listrxjavaandroid.BuildConfig
import com.flores.listrxjavaandroid.data.api.Retrofit2ApiManager
import com.flores.listrxjavaandroid.data.mapper.MovieMapper
import com.flores.listrxjavaandroid.domain.entity.MovieResult
import io.reactivex.Single

class MovieDataSourceImpl(private val api: Retrofit2ApiManager) :
    MovieDataSource {

    override fun getListMovies(page: Int): Single<MovieResult> {
        return api.processApi()!!.getListMovies(page,BuildConfig.TOKEN_SERVICE).map{ MovieMapper.movieResultResponseTransform(it) }
    }

}