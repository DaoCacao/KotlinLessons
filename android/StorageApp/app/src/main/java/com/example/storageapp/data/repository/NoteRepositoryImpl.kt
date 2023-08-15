package com.example.storageapp.data.repository

import com.example.storageapp.data.storage.firestore.FirestoreRemoteStorage
import com.example.storageapp.data.storage.room.RoomLocalStorage
import com.example.storageapp.domain.boundaries.repository.NoteRepository
import com.example.storageapp.domain.model.NoteModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import kotlin.random.Random

class NoteRepositoryImpl @Inject constructor(
    private val firestoreRemoteStorage: FirestoreRemoteStorage,
    private val roomLocalStorage: RoomLocalStorage,
) : NoteRepository {


    private fun synchronizeNotes(): Observable<List<NoteModel>> {
        return roomLocalStorage.getNotes()
            .flatMap { localList ->
                Observable.fromIterable(localList)
                    .flatMap {
                        firestoreRemoteStorage.setNote(it.id, it.title, it.content)
                            .toList()
                            .toObservable()
                    }
            }
    }

    private fun uploadRemoteNotes(): Observable<List<NoteModel>> {
        return firestoreRemoteStorage.getNotes()
            .flatMap {
                Observable.fromIterable(it)
                    .flatMap {
                        roomLocalStorage.addNote(it.id, it.title, it.content)
                            .toObservable()
                    }
            }
    }

    override fun getNotes(): Observable<List<NoteModel>> {
        synchronizeNotes()
            .subscribe()
        uploadRemoteNotes()
            .subscribe()
        return firestoreRemoteStorage.getNotes()
    }

    override fun getNote(noteId: String): Observable<NoteModel> {
        return roomLocalStorage.getNote(noteId)
    }

    override fun addNote(title: String, content: String): Single<String> {
        val id = Random.nextInt(100, 255).toString()
        return roomLocalStorage.addNote(id, title, content)
            .toSingleDefault(id)
            .flatMap { firestoreRemoteStorage.addNote(title, content) }

    }

    override fun updateNote(noteId: String, title: String, content: String): Completable {
        val note = NoteModel(noteId, title, content)
        return roomLocalStorage.updateNote(note)
    }

    override fun deleteNote(noteId: String): Completable {
        return roomLocalStorage.deleteNote(noteId)
    }

    companion object {
        const val ROOM = "Room"
        const val FIRESTORE = "Firestore"
    }
}