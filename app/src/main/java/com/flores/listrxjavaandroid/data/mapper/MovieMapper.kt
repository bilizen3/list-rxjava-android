package com.flores.listrxjavaandroid.data.mapper

import com.flores.listrxjavaandroid.data.entity.response.MovieItemResponse
import com.flores.listrxjavaandroid.data.entity.response.MovieResultResponse
import com.flores.listrxjavaandroid.domain.entity.Movie
import com.flores.listrxjavaandroid.domain.entity.MovieResult

object MovieMapper {

    fun movieResultResponseTransform(movieResultResponse: MovieResultResponse): MovieResult {
        val movieResult = MovieResult()
        movieResult.page = movieResultResponse.page
        movieResult.totalResults = movieResultResponse.total_results
        movieResult.totalPages = movieResultResponse.total_pages
        movieResult.results = moviesTransform(movieResultResponse.results)

        return movieResult
    }

    private fun moviesTransform(movieItemsResponse: List<MovieItemResponse>): List<Movie> {
        return movieItemsResponse.map {
            Movie(
                it.id,
                it.original_title,
                it.title,
                it.release_date,
                it.adult
            )
        }
    }

}