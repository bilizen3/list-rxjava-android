package com.flores.listrxjavaandroid.data.mapper

import com.flores.listrxjavaandroid.data.entity.response.EmployeeResponse
import com.flores.listrxjavaandroid.domain.entity.Employee

object EmployeeMapper {

    fun employeeResponseTransform(listEmployees: List<EmployeeResponse>): List<Employee> {
        return listEmployees.map {
            Employee(
                it.getId().toInt(),
                it.getEmployeeName(),
                it.getEmployeeSalary(),
                it.getEmployeeAge().toInt()
            )
        }
    }

}