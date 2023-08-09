package com.example.myapplication11

import android.app.Application
import com.example.myapplication11.utilit.PreferencesHelper

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        PreferencesHelper(this)
    }
}