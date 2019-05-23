package com.flores.listrxjavaandroid.data.model

data class EmployeeResponse(
    private val id: String,
    private val employee_name: String,
    private val employee_salary: String,
    private val employee_age: String,
    private val profile_image: String
) {
    fun getId(): String {
        return id
    }

    fun getEmployeeName(): String {
        return employee_name
    }

    fun getEmployeeSalary(): String {
        return employee_salary
    }

    fun getEmployeeAge(): String {
        return employee_age
    }
}


