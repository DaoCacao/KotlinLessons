package com.example.storageapp.di

import android.content.Context
import com.example.storageapp.data.mapper.NoteMapper
import com.example.storageapp.data.repository.NoteRepositoryImpl
import com.example.storageapp.data.storage.firestore.FirestoreRemoteStorage
import com.example.storageapp.data.storage.room.RoomLocalStorage
import com.example.storageapp.data.storage.room.database.AppDatabase
import com.example.storageapp.domain.boundaries.repository.NoteRepository
import com.example.storageapp.domain.use_case.AddNoteUseCase
import com.example.storageapp.domain.use_case.DeleteNoteUseCase
import com.example.storageapp.domain.use_case.GetNoteUseCase
import com.example.storageapp.domain.use_case.GetNotesUseCase
import com.example.storageapp.domain.use_case.UpdateNoteUseCase
import com.example.storageapp.presentation.model.NoteHolderMapper
import com.example.storageapp.presentation.note.NoteObject
import com.example.storageapp.presentation.note.NotePresenter
import com.example.storageapp.presentation.notes.NotesObject
import com.example.storageapp.presentation.notes.NotesPresenter
import com.google.firebase.firestore.FirebaseFirestore

fun provideNotesPresenter(context: Context, view: NotesObject.View) = NotesPresenter(
    view,
    provideGetNotesUseCase(context),
    provideAddNoteUseCase(context),
    provideDeleteNoteUseCase(context),
    NoteHolderMapper()
)

fun provideDeleteNoteUseCase(context: Context) = DeleteNoteUseCase(provideNotesRepository(context))
fun provideGetNotesUseCase(context: Context) = GetNotesUseCase(provideNotesRepository(context))
fun provideAddNoteUseCase(context: Context) = AddNoteUseCase(provideNotesRepository(context))
fun provideGetNoteUseCase(context: Context) = GetNoteUseCase(provideNotesRepository(context))
fun provideUpdateNoteUSeCAse(context: Context) = UpdateNoteUseCase(provideNotesRepository(context))
fun provideNotesRepository(context: Context): NoteRepository =
    NoteRepositoryImpl(providerFirestoreRemoteStorage(), provideRoomLocalStorage(context))

fun providerFirestoreRemoteStorage() =
    FirestoreRemoteStorage(FirebaseFirestore.getInstance(), NoteMapper())

fun provideRoomLocalStorage(context: Context) = RoomLocalStorage(provideDataBase(context), NoteMapper())

fun provideNotePresenter(context: Context, view: NoteObject.View) =
    NotePresenter(view, provideGetNoteUseCase(context), provideUpdateNoteUSeCAse(context))

fun provideDataBase(context: Context): AppDatabase {
    if (databaseInstance == null) databaseInstance = AppDatabase.build(context)
    return databaseInstance!!
}

private var databaseInstance: AppDatabase? = null