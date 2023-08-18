package com.example.dependencyinjection.presenter

import javax.inject.Inject

class TestPresenter @Inject constructor(private val view: Mvp.View) : Mvp.Presenter {

    override fun onSomething() {
        println("onSomething")
        view.showSomething()
    }
}