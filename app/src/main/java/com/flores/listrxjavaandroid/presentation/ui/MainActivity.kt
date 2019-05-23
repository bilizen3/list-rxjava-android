package com.flores.listrxjavaandroid.presentation.ui

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flores.listrxjavaandroid.R
import com.flores.listrxjavaandroid.data.api.Retrofit2ApiManager
import com.flores.listrxjavaandroid.data.datasource.EmployeeDataSourceImpl
import com.flores.listrxjavaandroid.data.repository.EmployeeRepositoryImpl
import com.flores.listrxjavaandroid.domain.model.Employee
import com.flores.listrxjavaandroid.domain.usecase.EmployeeUseCase
import com.flores.listrxjavaandroid.presentation.presenter.MainPresenter
import com.flores.listrxjavaandroid.presentation.presenter.MainPresenterImpl
import com.flores.listrxjavaandroid.presentation.view.MainView
import com.flores.listrxjavaandroid.util.Resource
import com.flores.listrxjavaandroid.util.Status
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var mainPresenter: MainPresenter

    private val progressDialog by lazy {
        ProgressDialog(this).apply {
            setMessage("Enviando")
            setCancelable(false)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val employeeDataSourceImpl = EmployeeDataSourceImpl(Retrofit2ApiManager)
        val employeeRepositoryImpl = EmployeeRepositoryImpl(employeeDataSourceImpl)
        val employeeUseCase = EmployeeUseCase(employeeRepositoryImpl)

        mainPresenter = MainPresenterImpl(this, employeeUseCase)


        btnShow.setOnClickListener {
            mainPresenter.getListEmployees()
        }

    }

    override fun responseShowListEmployees(response: Resource<String?>) {
        when (response.status) {
            Status.SUCCESS -> {
                progressDialog.hide()
                tvComment.text = response.data
            }
            Status.LOADING -> {
                progressDialog.show()

            }
            Status.ERROR -> {
                tvComment.text = response.message
            }
        }

    }
}
