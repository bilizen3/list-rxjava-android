package com.flores.listrxjavaandroid.data.mapper

import com.flores.listrxjavaandroid.data.entity.response.MovieItemResponse
import com.flores.listrxjavaandroid.data.entity.response.MovieResultResponse
import com.flores.listrxjavaandroid.domain.entity.Movie
import com.flores.listrxjavaandroid.domain.entity.MovieResult

object MovieMapper {

    fun movieResultResponseTransform(movieResultResponse: MovieResultResponse): MovieResult {
        val movieResult = MovieResult()
        movieResult.setPage(movieResultResponse.getPage())
        movieResult.setTotalResults(movieResultResponse.getTotalResults())
        movieResult.setTotalPages(movieResultResponse.getTotalPages())
        movieResult.setResults(moviesTransform(movieResultResponse.getResults()))
        return movieResult
    }

    private fun moviesTransform(movieItemsResponse: List<MovieItemResponse>): List<Movie> {
        return movieItemsResponse.map {
            Movie(
                it.getId(),
                it.getOriginalTitle(),
                it.getTitle(),
                it.getReleaseDate(),
                it.getAdult()
            )
        }
    }

}