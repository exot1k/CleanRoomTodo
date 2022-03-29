package com.exotik.cleanroomtodo.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note_table")
class StorageNoteModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String
)
