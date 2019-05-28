package com.flores.listrxjavaandroid.domain.entity

class MovieResult(
    var page: Int = 0,
    var totalResults: Int = 0,
    var totalPages: Int = 0,
    var results: List<Movie> = emptyList()
)

