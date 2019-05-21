package com.flores.listrxjavaandroid.data.mapper

import com.flores.listrxjavaandroid.data.model.EmployeeResponse
import com.flores.listrxjavaandroid.domain.model.Employee

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