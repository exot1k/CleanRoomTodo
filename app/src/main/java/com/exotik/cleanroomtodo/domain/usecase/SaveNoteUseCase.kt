package com.exotik.cleanroomtodo.domain.usecase

import com.exotik.cleanroomtodo.domain.models.DomainNoteModel
import com.exotik.cleanroomtodo.domain.repository.NoteRepository

class SaveNoteUseCase(private val noteRepository: NoteRepository) {
    suspend fun execute(note: DomainNoteModel): Boolean {
        return noteRepository.saveNote(note)
    }
}