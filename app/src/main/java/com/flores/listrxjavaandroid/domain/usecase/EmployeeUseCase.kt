package com.flores.listrxjavaandroid.domain.usecase

import com.flores.listrxjavaandroid.data.repository.MovieRepository
import com.flores.listrxjavaandroid.domain.entity.Movie
import io.reactivex.Single

class EmployeeUseCase(private val employeeRepository: MovieRepository) {

    fun getEmployees(): Single<List<Movie>> {
        return employeeRepository.getEmployee()
    }

}