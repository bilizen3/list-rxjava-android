package com.flores.listrxjavaandroid.data.entity.response

class MovieItemResponse(
    private val vote_count: Int = 0,
    val id: Int = 0,
    private val video: Boolean = false,
    private val vote_average: Double = 0.0,
    val title: String = "",
    private val popularity: Double = 0.0,
    private val poster_path: String = "",
    private val original_language: String = "",
    val original_title: String = "",
    private val genre_ids: List<Int> = emptyList(),
    private val backdrop_path: String = "",
    val adult: Boolean = false,
    private val overview: String = "",
    val release_date: String = ""
)