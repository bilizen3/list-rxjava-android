package com.flores.listrxjavaandroid.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.flores.listrxjavaandroid.R
import com.flores.listrxjavaandroid.data.api.Retrofit2ApiManager
import com.flores.listrxjavaandroid.data.datasource.remote.MovieDataSourceImpl
import com.flores.listrxjavaandroid.data.repository.MovieRepositoryImpl
import com.flores.listrxjavaandroid.domain.entity.Movie
import com.flores.listrxjavaandroid.domain.usecase.EmployeeUseCase
import com.flores.listrxjavaandroid.presentation.presenter.MainPresenter
import com.flores.listrxjavaandroid.presentation.presenter.MainPresenterImpl
import com.flores.listrxjavaandroid.presentation.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var mainPresenter: MainPresenter

    private val movieAdapter by lazy {
        MovieAdapter()
    }

    private var pageNow = 1
    private var pageTotal = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val employeeDataSourceImpl =
            MovieDataSourceImpl(Retrofit2ApiManager)
        val employeeRepositoryImpl = MovieRepositoryImpl(employeeDataSourceImpl)
        val employeeUseCase = EmployeeUseCase(employeeRepositoryImpl)

        mainPresenter = MainPresenterImpl(this, employeeUseCase)

        btnShow.setOnClickListener {
            mainPresenter.getListEmployees(pageNow)
        }

        rvNumbers.apply {
            addItemDecoration(
                androidx.recyclerview.widget.DividerItemDecoration(
                    this@MainActivity,
                    androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
                )
            )
            setHasFixedSize(true)
            adapter = movieAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val linearLayoutManager = layoutManager as androidx.recyclerview.widget.LinearLayoutManager
                    if (linearLayoutManager.itemCount == (linearLayoutManager.findLastVisibleItemPosition() + 1) &&
                        pageNow <= pageTotal &&
                        !movieAdapter.existsLoading()
                    ) {
                        pageNow++
                        mainPresenter.getListEmployees(pageNow)
                    }
                }
            })
        }

    }

    override fun addListMovies(movies: List<Movie>) {
        movieAdapter.addMovies(movies)
    }

    override fun showProgressBar() {
        movieAdapter.addLoading()
    }

    override fun hideProgressBar() {
        movieAdapter.removeLoading()
    }

    override fun updateTotalPages(pagesTotal: Int) {
        pageTotal = pagesTotal
    }

}

