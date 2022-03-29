package com.exotik.cleanroomtodo.data.storage


import androidx.lifecycle.LiveData
import com.exotik.cleanroomtodo.data.storage.model.StorageNoteModel


interface RoomStorage {
    suspend fun saveNote(note: StorageNoteModel): Boolean
    fun getAllNotes(): LiveData<MutableList<StorageNoteModel>>
    suspend fun delNote(position: Int): Boolean
}