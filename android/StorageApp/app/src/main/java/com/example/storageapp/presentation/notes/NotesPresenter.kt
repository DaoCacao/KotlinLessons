package com.example.storageapp.presentation.notes

import com.example.storageapp.domain.model.NoteModel
import com.example.storageapp.domain.use_case.AddNoteUseCase
import com.example.storageapp.domain.use_case.DeleteNoteUseCase
import com.example.storageapp.domain.use_case.GetNotesUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class NotesPresenter(
    private val view: NotesObject.View,
    private val getNotesUseCase: GetNotesUseCase,
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : NotesObject.Presenter {

    private lateinit var loadDataDisposable: Disposable
    private lateinit var addNoteDisposable: Disposable
    private lateinit var deleteNoteDisposable: Disposable
    private val composite = CompositeDisposable()

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
        composite.add(disposable)
    }

    override fun deleteNote(chosenId: Set<String>) {
        for (i in chosenId) {
            val disposable = deleteNoteUseCase.invoke(i)
                .subscribe()
            composite.add(disposable)
        }
    }

    override fun addNote() {
        val disposable = addNoteUseCase.invoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({}, { view.showFailToast() })

        composite.add(disposable)
    }

    override fun sortNotes(filtration: (item: List<NoteModel>) -> List<NoteModel>) {
        val disposable = getNotesUseCase.invoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.showLoading() }
            .map { noteList ->
                filtration(noteList)
                }
            .subscribe(
                { view.showNotes(it) },
                {
                    it.printStackTrace()
                    view.showError()
                },
            )
        composite.add(disposable)
    }

    override fun filterNotes(filter: String) {

        val disposable = getNotesUseCase.invoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.showLoading() }
            .map { noteList ->
                noteList.filter { it.title.contains(filter, true) }
            }
            .subscribe({
                view.showNotes(it)
            }, {
                it.printStackTrace()
                view.showError()
            })
        composite.add(disposable)
    }

    override fun dispose() {
        composite.dispose()
    }

    companion object {


        const val INCREASE = "increase"
        const val DECREASE = "decrease"
    }
}