package com.flores.listrxjavaandroid.domain.entity

class MovieResult(
    private var page: Int = 0,
    private var totalResults: Int = 0,
    private var totalPages: Int = 0,
    private var results: List<Movie> = emptyList()
) {
    fun setPage(page: Int) {
        this.page = page
    }

    fun setTotalResults(totalResults: Int) {
        this.totalResults = totalResults
    }

    fun setTotalPages(totalPages: Int) {
        this.totalPages = totalPages
    }

    fun setResults(results: List<Movie>) {
        this.results = results
    }

    fun getResults(): List<Movie> {
        return results
    }
}

