package com.flores.listrxjavaandroid.data.repository

import com.flores.listrxjavaandroid.data.model.Employee

interface EmployeeRepository {
    fun getEmployee(): List<Employee>
}