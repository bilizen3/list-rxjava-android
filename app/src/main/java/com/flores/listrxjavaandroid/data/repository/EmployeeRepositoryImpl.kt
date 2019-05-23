package com.flores.listrxjavaandroid.data.repository

import com.flores.listrxjavaandroid.data.datasource.remote.EmployeeDataSource
import com.flores.listrxjavaandroid.domain.entity.Employee
import io.reactivex.Single

class EmployeeRepositoryImpl(private val employeeDataSource: EmployeeDataSource) : EmployeeRepository {

    override fun getEmployee(): Single<List<Employee>> {
        return employeeDataSource.getEmployees()
    }

}