package com.example.storageapp.data.repository

import com.example.storageapp.data.storage.firestore.FirestoreRemoteStorage
import com.example.storageapp.data.storage.room.RoomLocalStorage
import com.example.storageapp.domain.boundaries.repository.NoteRepository
import com.example.storageapp.domain.model.NoteModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class NoteRepositoryImpl(
    private val firestoreRemoteStorage: FirestoreRemoteStorage,
    private val roomLocalStorage: RoomLocalStorage,
) : NoteRepository {
    override fun getNotes(): Observable<List<NoteModel>> {
        return roomLocalStorage.getNotes()
//        return firestoreRemoteStorage.getNotes()
    }

    override fun getNote(noteId: String): Observable<NoteModel> {
        return firestoreRemoteStorage.getNote(noteId)
    }

    override fun addNote(title: String, content: String): Single<String> {
        return firestoreRemoteStorage.addNote(title, content)
    }

    override fun updateNote(noteId: String, title: String, content: String): Completable {
        return firestoreRemoteStorage.updateNote(noteId, title, content)
    }

    override fun deleteNote(noteId: String): Completable {
        return firestoreRemoteStorage.deleteNote(noteId)
    }
}