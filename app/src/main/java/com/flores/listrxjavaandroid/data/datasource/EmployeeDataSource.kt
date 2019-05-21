package com.flores.listrxjavaandroid.data.datasource

import com.flores.listrxjavaandroid.domain.model.Employee
import io.reactivex.Single

interface EmployeeDataSource {

    fun getEmployees(): Single<List<Employee>>

}