package com.example.storageapp.data.storage.firestore

import com.example.storageapp.data.mapper.NoteMapper
import com.example.storageapp.domain.model.NoteModel
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class FirestoreRemoteStorage(
    private val firestore: FirebaseFirestore,
    private val mapper: NoteMapper,
) {

    fun getNotes(): Observable<List<NoteModel>> {
        return Observable.create { emitter ->
            firestore.collection("notes")
                .addSnapshotListener { value, error ->
                    if (value != null) emitter.onNext(value) // [{"title" to "Hello", "content" to "World },]
                    else if (error != null) emitter.onError(error)
                }
//                .get()
//                .addOnSuccessListener { notes ->  }
//                .addOnFailureListener { emitter.onError(it) }
        }.map { notes -> notes.map { note -> mapper.mapModel(note.id, note.data) } }
    }
}

//{
//    "notes": [
//    "ashdjkashdjkahAKSJFHKAS": {
//    "title" to "Hello",
//    "content" to "World",
//    }
//    ],
//}