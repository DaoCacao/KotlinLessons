package com.example.storageapp.presentation.model


import com.example.storageapp.presentation.model.NoteHolderModel
import com.example.storageapp.domain.model.NoteModel


class NoteHolderMapper {

    fun mapNoteToNoteHolder(id: String, title: String) = NoteHolderModel(
        id = id,
        title = title,
        isChecked = false
    )

    fun mapNoteListToNoteHolderList(noteList: List<NoteModel>) = List(
        noteList.size
    ) {
        mapNoteToNoteHolder(noteList[it].id, noteList[it].title)
    }

}