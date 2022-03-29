package com.exotik.cleanroomtodo.viewmodel

import androidx.lifecycle.*
import com.exotik.cleanroomtodo.domain.models.DomainNoteModel
import com.exotik.cleanroomtodo.domain.usecase.DelNoteUseCase
import com.exotik.cleanroomtodo.domain.usecase.GetAllNotesUseCase
import com.exotik.cleanroomtodo.domain.usecase.SaveNoteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val saveNoteUseCase: SaveNoteUseCase,
    private val delNoteUseCase: DelNoteUseCase,
) : ViewModel() {

    val noteLiveTest: LiveData<MutableList<DomainNoteModel>>
        get() {
            return getAllNotesUseCase.execute()
        }


    fun saveNote(title: String, description: String) {
        viewModelScope.launch(Dispatchers.IO) {
            saveNoteUseCase.execute(DomainNoteModel(title = title, descriptor = description))
        }
    }

    fun delNote(position: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            delNoteUseCase.execute(position)
        }
    }
}


