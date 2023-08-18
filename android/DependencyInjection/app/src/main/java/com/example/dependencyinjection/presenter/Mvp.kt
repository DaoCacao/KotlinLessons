package com.example.dependencyinjection.presenter

object Mvp {
    interface View {
        fun showSomething()
    }

    interface Presenter {
        fun onSomething()
    }
}