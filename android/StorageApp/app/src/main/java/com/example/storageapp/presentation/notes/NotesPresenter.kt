package com.example.storageapp.presentation.notes

import com.example.storageapp.domain.use_case.AddNoteUseCase
import com.example.storageapp.domain.use_case.DeleteNoteUseCase
import com.example.storageapp.domain.use_case.GetNotesUseCase
import com.example.storageapp.presentation.model.NoteHolderMapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class NotesPresenter(
    private val view: NotesObject.View,
    private val getNotesUseCase: GetNotesUseCase,
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val mapper: NoteHolderMapper
) : NotesObject.Presenter {

    private lateinit var loadDataDisposable: Disposable
    private lateinit var addNoteDisposable: Disposable
    private lateinit var deleteNoteDisposable: Disposable
    private val composite = CompositeDisposable()
    private val filtersForSort = FiltersForSort()
    private val deleteSet = mutableSetOf<String>()


    override fun loadData() {
        val disposable = getNotesUseCase.invoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.showLoading() }
            .subscribe(
                { notesList ->
                    view.showNotes(mapper.mapNoteListToNoteHolderList(notesList))
                },
                {
                    it.printStackTrace()
                    view.showError()
                },
            )
        composite.add(disposable)
    }

    override fun deleteNote() {
        for (i in deleteSet) {
            val disposable = deleteNoteUseCase.invoke(i)
                .subscribe()
            composite.add(disposable)
        }
    }

    override fun addToDeleteSet(noteId: String) {
        deleteSet.add(noteId)
    }

    override fun deleteFromDeleteSet(noteId: String) {
        deleteSet.remove(noteId)
    }

    override fun clearDeleteSet() {
        deleteSet.removeAll { true }
    }

    override fun addNote(title: String, content: String) {
        val disposable = addNoteUseCase.invoke(title, content)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.navigateToNoteActivity(it)
            },
                { view.showFailToast() })

        composite.add(disposable)
    }

    override fun sortNotes(filtration: String) {
        val disposable = getNotesUseCase.invoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.showLoading() }
            .map { noteList ->
                val holderList = mapper.mapNoteListToNoteHolderList(noteList)
                when (filtration) {
                    DECREASE -> {
                        filtersForSort.filterByAlphabetAtoZ(holderList)
                    }
                    INCREASE -> {
                        filtersForSort.filterByAlphabetZtoA(holderList)
                    }
                    else -> {
                        holderList
                    }
                }
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
            .map { notesList ->
                notesList.filter { it.title.contains(filter, true) }
            }
            .subscribe({ notesList ->
                val holderList = mapper.mapNoteListToNoteHolderList(notesList)
                view.showNotes(holderList)
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