package com.example.myapplication9.DataSave.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("model")
data class NoteModel (val title :String,val text :String,val date :String,val time :String){

    @PrimaryKey(true)
    var id :Int = 0
}
