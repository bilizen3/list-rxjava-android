package com.flores.listrxjavaandroid.data.entity.response

class MovieResultResponse(
    private var page: Int = 0,
    private var total_pages: Int = 0,
    private var results: List<MovieItemResponse> = emptyList(),
    private var total_results: Int = 0
) {
    fun getPage(): Int = page

    fun getTotalPages() = total_pages

    fun getResults() = results

    fun getTotalResults() = total_results
}