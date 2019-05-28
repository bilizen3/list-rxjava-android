package com.flores.listrxjavaandroid.data.entity.response

data class MovieItemResponse(
    private val vote_count: Int = 0,
    private var id: Int = 0,
    private val video: Boolean = false,
    private val vote_average: Double = 0.0,
    private var title: String = "",
    private val popularity: Double = 0.0,
    private val poster_path: String = "",
    private val original_language: String = "",
    private var original_title: String = "",
    private val genre_ids: List<Int> = emptyList(),
    private val backdrop_path: String = "",
    private var adult: Boolean = false,
    private val overview: String = "",
    private var release_date: String = ""
) {

    fun getId(): Int {
        return id
    }

    fun getTitle(): String {
        return title
    }

    fun getOriginalTitle(): String {
        return original_title
    }

    fun getAdult(): Boolean {
        return adult
    }

    fun getReleaseDate(): String {
        return release_date
    }

}