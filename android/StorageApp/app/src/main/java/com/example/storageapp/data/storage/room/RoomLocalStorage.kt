package com.example.storageapp.data.storage.room

import com.example.storageapp.data.mapper.NoteMapper
import com.example.storageapp.data.storage.room.database.AppDatabase

class RoomLocalStorage(
    private val database: AppDatabase,
    private val mapper: NoteMapper,
) {
    fun getNotes() = database.noteDao().getNotes().map { it.map { mapper.mapEntry(it) } }
}