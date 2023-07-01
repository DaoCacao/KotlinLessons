package com.example.storageapp.di

import com.example.storageapp.data.mapper.NoteMapper
import com.example.storageapp.data.repository.NoteRepositoryImpl
import com.example.storageapp.data.storage.firestore.FirestoreRemoteStorage
import com.example.storageapp.domain.boundaries.repository.NoteRepository
import com.example.storageapp.domain.use_case.GetNotesUseCase
import com.example.storageapp.presentation.notes.Notes
import com.example.storageapp.presentation.notes.NotesPresenter
import com.google.firebase.firestore.FirebaseFirestore

fun provideNotesPresenter(view: Notes.View) = NotesPresenter(view, provideGetNotesUseCase())
fun provideGetNotesUseCase() = GetNotesUseCase(provideNotesRepository())
fun provideNotesRepository(): NoteRepository = NoteRepositoryImpl(providerFirestoreRemoteStorage())
fun providerFirestoreRemoteStorage() = FirestoreRemoteStorage(FirebaseFirestore.getInstance(), NoteMapper())