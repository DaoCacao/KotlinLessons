package com.example.storageapp.presentation.notes

import com.example.storageapp.domain.model.NoteModel

class Filters {

    fun filterByAlphabetAtoZ(list: List<NoteModel>): List<NoteModel> {
        return list.sortedBy { it.title.lowercase() }
    }

    fun filterByAlphabetZtoA(list: List<NoteModel>): List<NoteModel> {
        return list.sortedByDescending { it.title.lowercase() }
    }

}