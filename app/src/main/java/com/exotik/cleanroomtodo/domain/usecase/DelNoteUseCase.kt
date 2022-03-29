package com.exotik.cleanroomtodo.domain.usecase

import com.exotik.cleanroomtodo.domain.repository.NoteRepository

class DelNoteUseCase(private val noteRepository: NoteRepository) {
    suspend fun execute(position: Int): Boolean {
        return noteRepository.delNote(position)
    }
}