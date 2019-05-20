package com.flores.listrxjavaandroid.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.flores.listrxjavaandroid.R
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import kotlinx.android.synthetic.main.activity_main.*
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

        var results = ""
        var error = ""
        var complete = ""

        list.toObservable().filter { it.length > 5 }.subscribeBy(  // named arguments for lambda Subscribers
            onNext = { results = "next" },
            onError = { error = "error" },
            onComplete = { complete = "complete" }
        )

        btnShow.setOnClickListener {
            Log.i("test", results)
            Log.i("test", error)
            Log.i("test", complete)
        }


        val integerObservable = Observable.create(ObservableOnSubscribe<Any> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
            it.onComplete()
        })

        val integerSubscriber = object : Subscriber<Any> {
            override fun onComplete() {
                Log.i("test", "complete")
            }

            override fun onSubscribe(s: Subscription?) {
                Log.i("test", "")
            }

            override fun onNext(t: Any?) {
                Log.i("test", t as String)
            }

            override fun onError(t: Throwable?) {
                Log.i("test", t.toString())
            }
        }

        integerObservable.subscribe(integerSubscriber)

    }
}
