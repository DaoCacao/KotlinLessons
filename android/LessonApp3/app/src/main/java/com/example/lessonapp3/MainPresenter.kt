package com.example.lessonapp3

class MainPresenter(private val _view: MainActivity): MainObject.Presenter {

    override fun signOut() {
        _view.navigationToEnterActivity()
    }
}