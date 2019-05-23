package com.flores.listrxjavaandroid.data.datasource.remote

import com.flores.listrxjavaandroid.domain.entity.Employee
import io.reactivex.Single

interface EmployeeDataSource {

    fun getEmployees(): Single<List<Employee>>

}