package com.flores.listrxjavaandroid.presentation.presenter

import com.flores.listrxjavaandroid.data.repository.EmployeeRepository
import com.flores.listrxjavaandroid.domain.usecase.EmployeeUseCase
import com.flores.listrxjavaandroid.presentation.view.MainView

class MainPresenterImpl(private var mainView: MainView) : MainPresenter {

    private val employeeRepository: EmployeeRepository? = null
    private val employeeUseCase: EmployeeUseCase? = null

    init {
        employeeUseCase=
    }

    override fun getListEmployees() {
        employeeUseCase?.getEmployees()

        mainView.showListEmployees()
    }


}