package com.flores.listrxjavaandroid.util

import com.flores.listrxjavaandroid.domain.entity.Movie

object EmployeeTransform {

    fun transformStringListEmployee(movies: List<Movie>): String {
        var text = ""
        for (employee in movies) {
            text += employee.getName() + "\n"
        }
        return text
    }

}