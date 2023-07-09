package com.example.storageapp.presentation.notes

import com.example.storageapp.presentation.model.NoteHolderModel

object NotesObject {
    interface View {
        fun showLoading()
        fun showNotes(notes: List<NoteHolderModel>)
        fun showError()
        fun navigateToNoteActivity(noteId: String)
        fun onNoteClick(note: NoteHolderModel)
        fun setDeleteState()
        fun setBasicState()
        fun setSearchState()
        fun onDeleteFubClick()
        fun showFailToast()
        fun onLongNoteClick(note: NoteHolderModel)
        fun onGoBackClick()
        fun onCheckBoxClick(note: NoteHolderModel)

    }

    interface Presenter {
        fun loadData()
        fun deleteNote()
        fun addNote(title: String, Content: String)
        fun dispose()
        fun filterNotes(filter:String)
        fun sortNotes(filtration: String)
        fun addToDeleteSet(noteId: String)
        fun deleteFromDeleteSet(noteId: String)
        fun clearDeleteSet()
    }
}