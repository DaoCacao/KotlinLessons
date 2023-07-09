package com.example.storageapp.presentation.notes

import com.example.storageapp.presentation.model.NoteHolderModel

class FiltersForSort {

    fun filterByAlphabetAtoZ(list: List<NoteHolderModel>): List<NoteHolderModel> {
        return list.sortedBy { it.title.lowercase() }
    }

    fun filterByAlphabetZtoA(list: List<NoteHolderModel>): List<NoteHolderModel> {
        return list.sortedByDescending { it.title.lowercase() }
    }

}