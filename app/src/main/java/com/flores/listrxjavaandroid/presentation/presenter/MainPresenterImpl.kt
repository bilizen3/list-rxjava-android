package com.flores.listrxjavaandroid.presentation.presenter

import com.flores.listrxjavaandroid.domain.model.Employee
import com.flores.listrxjavaandroid.domain.usecase.EmployeeUseCase
import com.flores.listrxjavaandroid.presentation.view.MainView
import com.flores.listrxjavaandroid.util.Resource
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainPresenterImpl(
    private val mainView: MainView,
    private val employeeUseCase: EmployeeUseCase
) : MainPresenter {

    override fun getListEmployees() {
        employeeUseCase.getEmployees()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Employee>> {
                override fun onSuccess(t: List<Employee>) {
                    var string = ""
                    for (employee in t) {
                        string += employee.name + "\n"

                    }
                    mainView.responseShowListEmployees(Resource.success(string))
                }

                override fun onSubscribe(d: Disposable) {
                    mainView.responseShowListEmployees(Resource.loading(null))
                }

                override fun onError(e: Throwable) {
                    mainView.responseShowListEmployees(Resource.error(e.toString(), null))
                }
            })
    }

}