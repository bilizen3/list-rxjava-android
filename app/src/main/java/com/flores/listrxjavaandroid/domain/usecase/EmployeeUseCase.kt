package com.flores.listrxjavaandroid.domain.usecase

import com.flores.listrxjavaandroid.data.repository.EmployeeRepository
import com.flores.listrxjavaandroid.domain.entity.Employee
import io.reactivex.Single

class EmployeeUseCase(private val employeeRepository: EmployeeRepository) {

    fun getEmployees(): Single<List<Employee>> {
        return employeeRepository.getEmployee()
    }

}