package com.flores.listrxjavaandroid.data.repository

import com.flores.listrxjavaandroid.data.datasource.EmployeeDataSource
import com.flores.listrxjavaandroid.domain.model.Employee
import io.reactivex.Single

class EmployeeRepositoryImpl(private val employeeDataSource: EmployeeDataSource) : EmployeeRepository {

    override fun getEmployee(): Single<List<Employee>> {
        return employeeDataSource.getEmployees()
    }

}