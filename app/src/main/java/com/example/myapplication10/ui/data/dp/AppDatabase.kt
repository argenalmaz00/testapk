package com.example.myapplication10.ui.data.dp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication10.ui.data.dp.daos.NoteDao
import com.example.myapplication9.DataSave.models.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class AppDatabase :RoomDatabase(){
    abstract fun noteDao() : NoteDao
}
