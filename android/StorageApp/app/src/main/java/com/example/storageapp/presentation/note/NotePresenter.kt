package com.example.storageapp.presentation.note

import com.example.storageapp.domain.use_case.GetNoteUseCase
import com.example.storageapp.domain.use_case.UpdateNoteUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class NotePresenter(
    val view: NoteObject.View,
    val getNoteUseCase: GetNoteUseCase,
    val updateNoteUseCase: UpdateNoteUseCase
) :
    NoteObject.Presenter {
    private lateinit var disposableGetNote: Disposable
    private lateinit var disposableUpdateNote: Disposable
    private lateinit var id: String

    override fun getNote(noteId: String) {
        disposableGetNote = getNoteUseCase.invoke(noteId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.showLoading() }
            .subscribe(
                {
                    id=it.id
                    view.initializeNote(it.title, it.content)
                },
                {
                    it.printStackTrace()
                    view.showError()
                },
            )
    }


    override fun updateNote(title: String, content: String) {
        disposableUpdateNote = updateNoteUseCase.invoke(id, title, content)
            .subscribe({}, {})
    }

    override fun disposeGetNote() {
        disposableGetNote.isDisposed
    }
}