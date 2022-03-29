package com.exotik.cleanroomtodo.data.storage.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.exotik.cleanroomtodo.data.storage.model.StorageNoteModel
import com.exotik.cleanroomtodo.data.storage.room.dao.NoteDao

@Database(entities = [StorageNoteModel::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object {
        private var db: NoteDataBase? = null

        @Synchronized
        fun getInstance(context: Context): NoteDataBase {
            if (db != null) return db as NoteDataBase
            db = Room.databaseBuilder(context, NoteDataBase::class.java, "db").build()
            return db as NoteDataBase
        }
    }
}