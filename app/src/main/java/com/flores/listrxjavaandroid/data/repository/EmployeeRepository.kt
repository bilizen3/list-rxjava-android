package com.flores.listrxjavaandroid.data.repository

import com.flores.listrxjavaandroid.domain.entity.Employee
import io.reactivex.Single

interface EmployeeRepository {
    fun getEmployee(): Single<List<Employee>>
}