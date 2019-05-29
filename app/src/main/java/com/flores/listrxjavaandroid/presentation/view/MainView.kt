package com.flores.listrxjavaandroid.presentation.view

import com.flores.listrxjavaandroid.domain.entity.Movie

interface MainView {

    fun addListMovies(movies: List<Movie>)
    fun showProgressBar()
    fun hideProgressBar()
    fun updateTotalPages(pagesTotal:Int)

}