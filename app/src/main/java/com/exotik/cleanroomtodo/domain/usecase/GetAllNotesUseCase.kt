package com.exotik.cleanroomtodo.domain.usecase


import androidx.lifecycle.LiveData
import com.exotik.cleanroomtodo.domain.models.DomainNoteModel
import com.exotik.cleanroomtodo.domain.repository.NoteRepository

class GetAllNotesUseCase(private val noteRepository: NoteRepository) {

    fun execute(): LiveData<MutableList<DomainNoteModel>> {
        return noteRepository.getAllNotes()
   }


}

