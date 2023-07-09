package com.example.storageapp.data.mapper

import com.example.storageapp.domain.model.NoteModel

class NoteMapper {
    fun mapCollection(id: String, data: Map<String, Any>) = NoteModel(
        id = id,
        title = data["title"] as String,
        content = data["content"] as String,
    )
}