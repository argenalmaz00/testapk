package com.example.myapplication10.ui

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.myapplication10.ui.data.dp.AppDatabase
import com.example.myapplication10.ui.utils.PreferenceHelper

class App :Application() {

    override fun onCreate() {
        super.onCreate()
        getInstance()
        context = this
        Log.d("start","App")
    }

    companion object{
        private var appDatabase : AppDatabase? = null
        private var context :Context? = null

        fun getInstance(): AppDatabase?{
            if (appDatabase == null){
                appDatabase = context?.let {
                    Room.databaseBuilder(it, AppDatabase::class.java,"note.database")
                        .fallbackToDestructiveMigration().allowMainThreadQueries().build()
                }
            }
            return appDatabase
        }
    }

    private fun initPrefrensShare(){
        PreferenceHelper(this).isHello
    }
}