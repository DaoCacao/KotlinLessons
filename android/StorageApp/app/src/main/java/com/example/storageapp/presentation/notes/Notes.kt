package com.example.storageapp.presentation.notes

import com.example.storageapp.domain.model.NoteModel

object Notes {
    interface View {
        fun showLoading()
        fun showNotes(notes: List<NoteModel>)
        fun showError()
    }

    interface Presenter {
        fun loadData()
    }
}