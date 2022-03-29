package com.exotik.cleanroomtodo.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.exotik.cleanroomtodo.data.storage.RoomStorage
import com.exotik.cleanroomtodo.data.storage.model.StorageNoteModel as StorageNoteModel
import com.exotik.cleanroomtodo.domain.models.DomainNoteModel as DomainNoteModel
import com.exotik.cleanroomtodo.domain.repository.NoteRepository

class NoteRepositoryImpl(private val roomStorage: RoomStorage) : NoteRepository {

    override fun getAllNotes(): LiveData<MutableList<DomainNoteModel>> {
        return Transformations.map(roomStorage.getAllNotes()) { note ->
            return@map note.map { mapToDomain(it) }.toMutableList()
        }
    }

    override suspend fun delNote(position: Int): Boolean {
        return roomStorage.delNote(position)
    }

    override suspend fun saveNote(note: DomainNoteModel): Boolean {
        return roomStorage.saveNote(mapToStorage(note))
    }

    private fun mapToDomain(note: StorageNoteModel): DomainNoteModel {
        return DomainNoteModel(title = note.title, descriptor = note.description, id = note.id)
    }

    private fun mapToStorage(note: DomainNoteModel): StorageNoteModel {
        return StorageNoteModel(id = 0, title = note.title, description = note.descriptor)
    }
}
