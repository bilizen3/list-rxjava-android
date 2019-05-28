package com.flores.listrxjavaandroid.domain.entity

import com.flores.listrxjavaandroid.presentation.ui.ViewType
import com.flores.listrxjavaandroid.util.ITEM_MOVIE

class Movie(
    private val id: Int = 0,
    private val originalTitle: String = "",
    private val title: String = "",
    private val releaseDate: String = "",
    private val adult: Boolean = false
) : ViewType {

    override fun getViewType() = ITEM_MOVIE

    fun getId(): Int {
        return id
    }

    fun getTitle(): String {
        return title
    }

    fun getAdult(): Boolean {
        return adult
    }

}