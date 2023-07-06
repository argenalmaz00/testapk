package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MyTowActivity : AppCompatActivity() {
    private  lateinit var text_view:TextView
    private  lateinit var icon:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mytowactivity)
        text_view = findViewById(R.id.text_two)
        icon = findViewById(R.id.img_icon)
        whatsapp()
        google()
        get_img()

    }

    private fun get_img() {
        icon.setImageResource(R.drawable.ic_launcher_background)
        icon.setOnClickListener {
            val inted = Intent(Intent.ACTION_GET_CONTENT)
            inted.type = "image/*"
            startActivityForResult(Intent.createChooser(inted,"get Image"),200)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 200){
            data?.data?.let {
                icon.setImageURI(it)
            }

        }
    }

    private fun google() {
        intent.extras?.getString("text").apply {
            text_view.text = this.toString()
        }
        intent.extras?.getInt("icon").also {
            if (it != null) {
                icon.setImageResource(it)
            }
        }
    }

    private fun whatsapp() {
        intent.extras?.getString("text").apply {
            text_view.text = this.toString()
        }
        intent.extras?.getInt("icon").also {
            if (it != null) {
                icon.setImageResource(it)
            }
        }
    }
}