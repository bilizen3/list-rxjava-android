package com.flores.listrxjavaandroid.domain.usecase

import com.flores.listrxjavaandroid.data.repository.MovieRepository
import com.flores.listrxjavaandroid.domain.entity.MovieResult
import io.reactivex.Single

class EmployeeUseCase(private val employeeRepository: MovieRepository) {

    fun getEmployees(page: Int): Single<MovieResult> {
        return employeeRepository.getEmployee(page)
    }

}