package com.exotik.cleanroomtodo.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.exotik.cleanroomtodo.data.repository.NoteRepositoryImpl
import com.exotik.cleanroomtodo.data.storage.room.RoomStorageImpl
import com.exotik.cleanroomtodo.domain.usecase.DelNoteUseCase
import com.exotik.cleanroomtodo.domain.usecase.GetAllNotesUseCase
import com.exotik.cleanroomtodo.domain.usecase.SaveNoteUseCase

class NoteViewModelFactory(context: Context) : ViewModelProvider.NewInstanceFactory() {

    private val noteRepository by lazy(LazyThreadSafetyMode.NONE) {
        NoteRepositoryImpl(roomStorage = RoomStorageImpl(context = context))
    }

    private val getAllNotesUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetAllNotesUseCase(noteRepository = noteRepository)
    }
    private val saveNoteUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveNoteUseCase(noteRepository = noteRepository)
    }

    private val delNoteUseCase by lazy(LazyThreadSafetyMode.NONE) {
        DelNoteUseCase(noteRepository = noteRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(
            getAllNotesUseCase = getAllNotesUseCase,
            saveNoteUseCase = saveNoteUseCase,
            delNoteUseCase = delNoteUseCase,
        ) as T
    }
}