package com.example.storageapp.di

import com.example.storageapp.data.mapper.NoteMapper
import com.example.storageapp.data.repository.NoteRepositoryImpl
import com.example.storageapp.data.storage.firestore.FirestoreRemoteStorage
import com.example.storageapp.domain.boundaries.repository.NoteRepository
import com.example.storageapp.domain.use_case.*
import com.example.storageapp.presentation.note.NoteObject
import com.example.storageapp.presentation.note.NotePresenter
import com.example.storageapp.presentation.notes.NotesObject
import com.example.storageapp.presentation.notes.NotesPresenter
import com.example.storageapp.presentation.model.NoteHolderMapper
import com.google.firebase.firestore.FirebaseFirestore

fun provideNotesPresenter(view: NotesObject.View) = NotesPresenter(
    view,
    provideGetNotesUseCase(),
    provideAddNoteUseCase(),
    provideDeleteNoteUseCase(),
    NoteHolderMapper()
)

fun provideDeleteNoteUseCase() = DeleteNoteUseCase(provideNotesRepository())
fun provideGetNotesUseCase() = GetNotesUseCase(provideNotesRepository())
fun provideAddNoteUseCase() = AddNoteUseCase(provideNotesRepository())
fun provideGetNoteUseCase() = GetNoteUseCase(provideNotesRepository())
fun provideUpdateNoteUSeCAse() = UpdateNoteUseCase(provideNotesRepository())
fun provideNotesRepository(): NoteRepository = NoteRepositoryImpl(providerFirestoreRemoteStorage())
fun providerFirestoreRemoteStorage() =
    FirestoreRemoteStorage(FirebaseFirestore.getInstance(), NoteMapper())

fun provideNotePresenter(view: NoteObject.View) =
    NotePresenter(view, provideGetNoteUseCase(), provideUpdateNoteUSeCAse())
