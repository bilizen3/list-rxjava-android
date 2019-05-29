package com.flores.listrxjavaandroid.presentation.presenter

import com.flores.listrxjavaandroid.domain.entity.MovieResult
import com.flores.listrxjavaandroid.domain.usecase.EmployeeUseCase
import com.flores.listrxjavaandroid.presentation.view.MainView
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainPresenterImpl(
    private val mainView: MainView,
    private val employeeUseCase: EmployeeUseCase
) : MainPresenter {

    override fun getListEmployees(page: Int) {
        employeeUseCase.getEmployees(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<MovieResult> {
                override fun onSuccess(t: MovieResult) {
                    mainView.hideProgressBar()
                    mainView.addListMovies(t.getResults())
                    mainView.updateTotalPages(t.getTotalPages())
                }

                override fun onSubscribe(d: Disposable) {
                    mainView.showProgressBar()
                }

                override fun onError(e: Throwable) {
                    mainView.hideProgressBar()
                }
            })
    }

}