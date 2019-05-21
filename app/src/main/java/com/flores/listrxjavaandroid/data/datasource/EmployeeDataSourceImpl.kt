package com.flores.listrxjavaandroid.data.datasource

import com.flores.listrxjavaandroid.data.api.Retrofit2ApiManager
import com.flores.listrxjavaandroid.data.mapper.EmployeeMapper
import com.flores.listrxjavaandroid.domain.model.Employee
import io.reactivex.Single

class EmployeeDataSourceImpl(private val api: Retrofit2ApiManager) : EmployeeDataSource {

    override fun getEmployees(): Single<List<Employee>> {
        return api.processApi()!!.getEmployees().map{ EmployeeMapper.employeeResponseTransform(it) }
    }

}