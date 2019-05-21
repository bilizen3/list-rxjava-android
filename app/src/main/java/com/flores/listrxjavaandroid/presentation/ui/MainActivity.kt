package com.flores.listrxjavaandroid.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flores.listrxjavaandroid.R
import com.flores.listrxjavaandroid.presentation.presenter.MainPresenter
import com.flores.listrxjavaandroid.presentation.presenter.MainPresenterImpl
import com.flores.listrxjavaandroid.presentation.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    val mainPresenter : MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter= MainPresenterImpl(this)
        tvComment.text = ""
    }

    override fun showListEmployees() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
