package com.example.myapplication10.ui.utils.SQLhelper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class SQLhelper(context :Context) :SQLiteOpenHelper(context, DATA_NAME, null, VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP)
        onCreate(db)
    }
    fun getAll():ArrayList<NoteClass>?{
        readableDatabase.apply {
        try {
            val cursor :Cursor = rawQuery(SELECT,null)
            cursor.moveToFirst()
            val list = ArrayList<NoteClass>()
            do {
                val id = cursor.getInt(cursor.getColumnIndex(ID))
                val title = cursor.getString(cursor.getColumnIndex(TITLE))
                val text = cursor.getString(cursor.getColumnIndex(TEXT))
                val date = cursor.getString(cursor.getColumnIndex(DATE))
                val time = cursor.getString(cursor.getColumnIndex(TIME))
                list.add(NoteClass(id,title,text,date,time))

                }while (cursor.moveToNext())
            return list
            }
        catch (e :Exception){
                Log.e("ERROR",e.stackTraceToString())
            }

        }
        return null
    }
    fun addData(noteClass: NoteClass) = with(noteClass){
        writableDatabase.apply {
            ContentValues().apply {
                put(TITLE,title)
                put(TEXT,text)
                put(DATE,Date)
                put(TIME,Time)
                insert(TABLE_NAME,null,this)
            }
        }
    }

    companion object{
        const val DATA_NAME = "data_name.db"
        const val VERSION = 1
        const val TABLE_NAME = "table_name"
        const val ID = "id"
        const val COLOR = "color"
        const val TITLE = "titlel"
        const val TEXT = "text"
        const val DATE = "DATE"
        const val TIME = "time"
        //sql GET and POST
        const val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($ID integer auto_increment primary key ,$COLOR INT,$TITLE text,$TEXT text,$DATE text,$TIME text)"
        const val SELECT = "SELECT * FROM $TABLE_NAME"
        const val INSERT_VALUE = "insert into $TABLE_NAME ($TITLE,$TEXT,$DATE,$TIME) value "
        const val DROP = "DROP TABLE if exist $TABLE_NAME"
    }
}