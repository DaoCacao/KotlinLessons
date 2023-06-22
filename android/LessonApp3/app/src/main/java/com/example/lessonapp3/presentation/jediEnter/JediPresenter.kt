package com.example.lessonapp3.presentation.jediEnter

import com.example.lessonapp3.SignUpException
import com.example.lessonapp3.UserService
import com.example.lessonapp3.data.model.JediRaw
import com.example.lessonapp3.data.remote.JediGetter
import com.example.lessonapp3.data.remote.JediRemoteStorage
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class JediPresenter(
    val view: JediObject.View,
    private val remoteStorage: JediRemoteStorage,
    val userService: UserService,
    private val jediGetter: JediGetter
) :
    JediObject.Presenter {

    lateinit var disposableGetAllJedi: Disposable
    lateinit var disposableSignInAsJedi: Disposable

    var jediName = ""
    var jediPassword = ""

    override fun getAllJedi() {
        jediGetter.getJedi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({it.forEach { println(it.name) }},{})

    }

    override fun jediNameInput(name: String) {
        jediName = name
    }

    override fun jediPasswordInput(password: String) {
        jediPassword = password
    }

    override fun signInAsJedi() {

    }


    override fun dispose() {
        disposableGetAllJedi.dispose()
    }

}