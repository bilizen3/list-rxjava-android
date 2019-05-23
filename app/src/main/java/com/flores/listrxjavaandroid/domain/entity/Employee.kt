package com.flores.listrxjavaandroid.domain.entity

class Employee(
    private val id: Int,
    private val name: String,
    private val salary: String,
    private val age: Int
) {

    fun getName(): String {
        return name
    }

}