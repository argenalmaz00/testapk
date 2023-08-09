package com.example.myapplication11.utilit

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper(private val context: Context) {

    private var sharedPreferences: SharedPreferences = context.getSharedPreferences("passport", Context.MODE_PRIVATE)

    var name
        set(value) = sharedPreferences.edit()?.putString("name",value!!)!!.apply()
        get() = sharedPreferences.getString("name","")

    var surname
        set(value)  = sharedPreferences.edit()?.putString("surname",value!!)!!.apply()
        get() = sharedPreferences.getString("surname","")

}