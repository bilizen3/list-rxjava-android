package com.flores.listrxjavaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

        var results = ""
        list.toObservable().filter { it.length > 5 }.subscribeBy(  // named arguments for lambda Subscribers
            onNext = { results = "next" },
            onError = { results = "error" },
            onComplete = { results = "complete" }
        )

        btnShow.setOnClickListener {

        }

    }
}
