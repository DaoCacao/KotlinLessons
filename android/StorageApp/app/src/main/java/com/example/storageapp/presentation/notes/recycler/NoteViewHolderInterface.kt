package com.example.storageapp.presentation.notes.recycler

import com.example.storageapp.domain.model.NoteModel

interface NoteViewHolderInterface {

        fun bind(note: NoteModel)
        fun showCheckBox()
        fun hideCheckBox()
        fun check(): Boolean
        fun uncheckAll()

}