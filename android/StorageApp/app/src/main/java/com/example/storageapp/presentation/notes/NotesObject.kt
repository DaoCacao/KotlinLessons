package com.example.storageapp.presentation.notes

import com.example.storageapp.domain.model.NoteModel

object NotesObject {
    interface View {
        fun showLoading()
        fun showNotes(notes: List<NoteModel>)
        fun showError()
        fun navigateToNoteActivity(noteId: String)
        fun onNoteClick(noteModel: NoteModel)
        fun setDeleteState()
        fun setBasicState()
        fun setSortedState(filtration: (item: List<NoteModel>) -> List<NoteModel>)
        fun setBasicStateAfterSearch()
        fun setSearchState()
        fun onDeleteFubClick()
        fun showFailToast()
        fun onLongNoteClick(note: NoteModel)
        fun onGoBackClick()

    }

    interface Presenter {
        fun loadData()
        fun deleteNote(chosenId: Set<String>)
        fun addNote()
        fun dispose()
        fun filterNotes(filter:String)
        fun sortNotes(filtration: (item: List<NoteModel>) -> List<NoteModel>)
    }
}