package com.exotik.cleanroomtodo.data.storage.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.exotik.cleanroomtodo.data.storage.model.StorageNoteModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: StorageNoteModel)

//    @Delete
//    suspend fun delete(note: StorageNoteModel)

    @Query("DELETE FROM note_table WHERE ID =:id")
    suspend fun delete(id: Int)

    @Query("SELECT *  FROM note_table")
    fun getAllNotes(): LiveData<MutableList<StorageNoteModel>>

}
