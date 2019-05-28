package com.flores.listrxjavaandroid.data.entity.response

class MovieResultResponse(
    var page: Int = 0,
    var total_pages: Int = 0,
    var results: List<MovieItemResponse> = emptyList(),
    var total_results: Int = 0
)