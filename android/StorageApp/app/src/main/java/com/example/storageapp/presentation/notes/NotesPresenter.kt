package com.example.storageapp.presentation.notes

import com.example.storageapp.domain.use_case.GetNotesUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class NotesPresenter(
    private val view: Notes.View,
    private val getNotesUseCase: GetNotesUseCase,
) : Notes.Presenter {
    override fun loadData() {
        val disposable = getNotesUseCase.invoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.showLoading() }
            .subscribe(
                { view.showNotes(it) },
                {
                    it.printStackTrace()
                    view.showError()
                },
            )
    }

}