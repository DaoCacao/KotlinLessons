package com.example.lessonapp3

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class Calculator {
    fun sum(a: Int, b: Int): Single<Int> {
//        return Single.just(a + b)
        return Single.create {
            val result = a + b
            it.onSuccess(result)
        }
    }
}

class MainActivity : AppCompatActivity() {

    // Емиттер последнего актуального пользователя
    private val currentUser = PublishSubject.create<User>()
    val calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.text)
        val button = findViewById<Button>(R.id.button)


        calculator
            .sum(1, 2)
            .subscribe()

        // Emitters

        // эмитит только один объект
//        Single<String>

        // как синг, но может не прислать значение
//        Maybe<String>

        // выполняет последовательность и не возвращает объект
//        Completable

        // эмитит объекты постоянно
//        Observable<String>


        button.setOnClickListener { updateUser() }

        currentUser
            .map { it.copy(name = it.name + " AHAHA") }
            .subscribe { user -> text.text = user.name }
    }

    fun onButtonClick() {
        runObservable()
    }

    fun updateUser() {
        currentUser.onNext(User(0, "John ${Random.nextInt(100)}"))
    }

    fun runSingle() {
        Single
            .just(User(0, "John"))
            .delay(5, TimeUnit.SECONDS)
            .doOnSubscribe { Log.d("RX", "On Subscribe") }
            .map { it.copy(id = it.id, name = it.name + " Doe") }
            // error way
//            .map { it.copy(id = it.id / 0, name = it.name + " Doe") }
            .subscribe(
                { user -> Log.d("RX", user.toString()) },
                { t -> Log.d("RX", t.toString()) },
            )
    }

    fun runObservable() {
//        var disposable: Disposable? = null
//        disposable = Observable.interval(0L, 1L, TimeUnit.SECONDS)
//            .doOnNext { Log.d("RX", "Do on next $it") }
//            .filter { it % 2 == 0L }
//            .subscribe(
//                { tick ->
//                    Log.d("RX", "On next $tick")
//                    if (tick == 10L) disposable?.dispose()
//                },
//                { t -> Log.d("RX", t.toString()) },
//                { Log.d("RX", "Completed") }
//            )

        Observable.create<String> {
            if (Random.nextBoolean()) {
                it.onNext("Hello world")
            } else {
                it.onNext("1")
                it.onNext("2")
                it.onNext("3")
            }
            it.onComplete()
        }
            .delay(1, TimeUnit.SECONDS)
            .subscribe(
                /* onNext = */ { Log.d("RX", "ON Next $it") },
                /* onError = */ { Log.d("RX", it.toString()) },
                /* onComplete = */ { Log.d("RX", "Completed") }
            )
    }
}