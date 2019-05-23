package com.flores.listrxjavaandroid.util

import com.flores.listrxjavaandroid.domain.entity.Employee

object EmployeeTransform {

    fun transformStringListEmployee(employees: List<Employee>): String {
        var text = ""
        for (employee in employees) {
            text += employee.getName() + "\n"
        }
        return text
    }

}