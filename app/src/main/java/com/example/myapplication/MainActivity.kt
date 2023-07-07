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
    private  lateinit var edit_text:EditText
    private lateinit var  bt_get:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit_text = findViewById(R.id.edit_text)
        bt_get = findViewById(R.id.bt_get)

        getEdit()
    }

    private fun getEdit() {
        bt_get.setOnClickListener {
            val text = edit_text.text.toString()
            if (text != null){
                when(text){
                    ob.WHATSAPP ->{
                        val packg = "com.whatsapp"
                        val inted = packageManager.getLaunchIntentForPackage(packg)
                        startActivity(inted)

                    }
                    ob.GOOGLE ->{
                        Intent(Intent.ACTION_VIEW,Uri.parse("https://google.com")).apply {
                        startActivity(this)
                        }
                    }
                    ob.YOUTUBE ->{
                        Intent(Intent.ACTION_VIEW,Uri.parse("https://youtube.com")).apply {
                            startActivity(this)
                        }
                    }
                    else ->{
                        Intent(this,MyTowActivity::class.java).apply {
                            this.putExtra("text",edit_text.text.toString())
                            startActivity(this)
                        }
                    }
                }
            }
        }
    }
    object ob {
        val WHATSAPP = "whatsapp"
        val YOUTUBE = "youtube"
        val GOOGLE ="google"
    }

}