package com.example.myapplication10.ui.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {
    private var sharedPreferences : SharedPreferences = context.getSharedPreferences("data_hello",Context.MODE_PRIVATE)

    var isHello
        set(value) = sharedPreferences.edit()?.putBoolean("isHello",value!!)!!.apply()
        get() = sharedPreferences.getBoolean("isHello",false)
}