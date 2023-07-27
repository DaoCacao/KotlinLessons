package com.example.storageapp.data.repository

import com.example.storageapp.data.storage.firestore.FirestoreRemoteStorage
import com.example.storageapp.data.storage.room.RoomLocalStorage
import com.example.storageapp.domain.boundaries.repository.NoteRepository
import com.example.storageapp.domain.model.NoteModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import kotlin.random.Random

class NoteRepositoryImpl(
    private val firestoreRemoteStorage: FirestoreRemoteStorage,
    private val roomLocalStorage: RoomLocalStorage,
) : NoteRepository {
    val repository = ROOM

    override fun synchronizeNotes(): Completable {
        return roomLocalStorage.getNotes()
            .flatMapCompletable { localList ->
                Observable.fromIterable(localList)
                    .flatMapCompletable {
                        firestoreRemoteStorage.setNote(it.id, it.title, it.content)
                    }
            }
    }

    override fun getNotes(): Observable<List<NoteModel>> {
        synchronizeNotes()
            .subscribe()
        return firestoreRemoteStorage.getNotes()
    }

    override fun getNote(noteId: String): Observable<NoteModel> {

        return if (repository == FIRESTORE) {
            firestoreRemoteStorage.getNote(noteId)
        } else {
            roomLocalStorage.getNote(noteId)
        }
    }

    override fun addNote(title: String, content: String): Single<String> {
        val id = Random.nextInt(100, 255).toString()
        return roomLocalStorage.addNote(id, title, content)
            .toSingleDefault(id)
            .flatMap { firestoreRemoteStorage.addNote(title, content) }

    }

    override fun updateNote(noteId: String, title: String, content: String): Completable {
        val note=NoteModel(noteId, title, content)
        return firestoreRemoteStorage.updateNote(noteId, title, content)
            .mergeWith { roomLocalStorage.updateNote(note) }
    }

    override fun deleteNote(noteId: String): Completable {

        return roomLocalStorage.deleteNote(noteId)
    }

    companion object {
        const val ROOM = "Room"
        const val FIRESTORE = "Firestore"
    }
}