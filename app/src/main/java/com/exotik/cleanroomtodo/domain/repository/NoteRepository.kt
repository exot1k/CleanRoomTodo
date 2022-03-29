package com.exotik.cleanroomtodo.domain.repository

import androidx.lifecycle.LiveData
import com.exotik.cleanroomtodo.domain.models.DomainNoteModel


interface NoteRepository {
    suspend fun saveNote(note: DomainNoteModel): Boolean

    fun getAllNotes(): LiveData<MutableList<DomainNoteModel>>
    suspend fun delNote(position: Int): Boolean
}