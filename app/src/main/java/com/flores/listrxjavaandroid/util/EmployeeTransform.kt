package com.flores.listrxjavaandroid.util

import com.flores.listrxjavaandroid.domain.entity.Movie

object EmployeeTransform {

    fun transformStringListEmployee(movies: List<Movie>): String {
        var text = ""
        for (movie in movies) {
            text += movie.getMovie() + "\n"
        }
        return text
    }

}