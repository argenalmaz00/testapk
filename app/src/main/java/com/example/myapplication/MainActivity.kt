package com.example.myapplication

import android.app.Notification
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private  lateinit var bt_whatsapp:Button
    private  lateinit var bt_google:Button
    private  lateinit var bt_youtube:Button
    private  lateinit var edit_text:EditText
    private lateinit var  bt_get:Button
    private lateinit var  bt_get_img:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_whatsapp = findViewById(R.id.button_whatsapp)
        bt_google = findViewById(R.id.button_google)
        bt_youtube = findViewById(R.id.button_youtube)
        edit_text = findViewById(R.id.edit_text)
        bt_get = findViewById(R.id.bt_get)

        whatsapp()
        google()
        youtube()
        Get()
    }
    private fun Get() {
        bt_get.setOnClickListener {
            val text = edit_text.text.toString()
            if (text.isNotEmpty()){
                val inted = Intent(this,MyTowActivity::class.java)
                inted.putExtra("text",text)
                startActivity(inted)

            }
        }
    }

    private fun youtube() {
        bt_youtube.setOnClickListener {
            val text = edit_text.text.toString()
            if (text.isNotEmpty()){
                val inted = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/results?search_query=${text}"))
                startActivity(inted)
            }
        }
    }

    private fun google() {
        bt_google.setOnClickListener{
            val text = edit_text.text.toString()
            if (text.isNotEmpty()){
                val inted = Intent(this,MyTowActivity::class.java)
                inted.putExtra("icon",R.drawable.google)
                inted.putExtra("text",text)
                startActivity(inted)
            }
        }
    }

    private fun whatsapp() {
        bt_whatsapp.setOnClickListener{
            val text  = edit_text.text.toString()
            if (text.isNotEmpty()){
                val inted = Intent(this,MyTowActivity::class.java)
                inted.putExtra("icon",R.drawable.whatsapp)
                inted.putExtra("text",text)
                startActivity(inted)
            }

        }
    }
}