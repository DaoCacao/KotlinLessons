package com.example.storageapp.data.mapper

import com.example.storageapp.data.storage.room.entity.NoteEntity
import com.example.storageapp.domain.model.NoteModel

class NoteMapper {
    fun mapCollection(id: String, data: Map<String, Any>) = NoteModel(
        id = id,
        title = data["title"] as String,
        content = data["content"] as String,
    )

    fun mapEntry(entry: NoteEntity) = NoteModel(
        id = entry.id,
        title = entry.title ?: "",
        content = entry.content ?: "",
    )
}