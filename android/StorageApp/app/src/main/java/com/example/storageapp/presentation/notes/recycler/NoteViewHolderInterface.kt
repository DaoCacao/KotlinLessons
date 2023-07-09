package com.example.storageapp.presentation.notes.recycler

import com.example.storageapp.presentation.model.NoteHolderModel

interface NoteViewHolderInterface {

        fun bind(note: NoteHolderModel)
        fun showCheckBox()
        fun hideCheckBox()
        fun check(check: Boolean)
        fun getNoteId(note: NoteHolderModel):String

}