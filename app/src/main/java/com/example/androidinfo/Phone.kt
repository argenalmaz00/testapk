package com.example.androidinfo

import android.widget.Toast

class Phone{

    fun GetInfo(ge:(model:String,ram:Int,memory:Int)->Unit){
        ge("Xiaomi Redmi 8",4,64)
        }

    inner class WiFi{
        private val password:String = "geeks"
        fun connect (pass_user:String , resulit:(Boolean)->Unit){
            if (pass_user == password){
                resulit(true)
            }
            else{
                resulit(false)
            }
        }
    }
}