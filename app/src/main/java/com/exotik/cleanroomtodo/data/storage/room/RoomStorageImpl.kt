package com.exotik.cleanroomtodo.data.storage.room

import android.content.Context
import androidx.lifecycle.LiveData
import com.exotik.cleanroomtodo.data.storage.RoomStorage
import com.exotik.cleanroomtodo.data.storage.model.StorageNoteModel
import com.exotik.cleanroomtodo.data.storage.room.dao.NoteDao
import com.exotik.cleanroomtodo.data.storage.room.db.NoteDataBase

class RoomStorageImpl(context: Context) : RoomStorage {
    private var noteDao: NoteDao = NoteDataBase.getInstance(context).getNoteDao()

    override suspend fun saveNote(note: StorageNoteModel): Boolean {
        noteDao.insert(StorageNoteModel(id = 0, note.title, note.description))
        return true
    }

    override fun getAllNotes(): LiveData<MutableList<StorageNoteModel>> {
        return noteDao.getAllNotes()
    }


    override suspend fun delNote(position: Int): Boolean {
        noteDao.delete(position)
        return true
    }

}