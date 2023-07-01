package com.example.storageapp.data.repository

import com.example.storageapp.data.storage.firestore.FirestoreRemoteStorage
import com.example.storageapp.domain.boundaries.repository.NoteRepository
import com.example.storageapp.domain.model.NoteModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class NoteRepositoryImpl(
    private val firestoreRemoteStorage: FirestoreRemoteStorage,
) : NoteRepository {
    override fun getNotes(): Observable<List<NoteModel>> {
        return firestoreRemoteStorage.getNotes()
    }

    override fun getNote(noteId: String): Observable<NoteModel> {
        TODO("Not yet implemented")
    }

    override fun addNote(title: String, content: String): Completable {
        TODO("Not yet implemented")
    }

    override fun updateNote(noteId: String, title: String, content: String): Completable {
        TODO("Not yet implemented")
    }

    override fun deleteNote(noteId: String): Completable {
        TODO("Not yet implemented")
    }
}