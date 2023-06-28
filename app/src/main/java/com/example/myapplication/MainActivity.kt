package com.example.myapplication

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    var films = ArrayList<Films>()
    lateinit var textView: TextView
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        films.add(Films.kino1(0,"Страные кино 5",2020,"каойта кино"))
        films.add(Films.kino2(1,"хоть бы в кино",2010,"каойта кино"))
        films.forEach(){
            when(it){
                is Films.kino1 ->{
                    imageView = findViewById(R.id.IV_kino1)
                    imageView.setImageResource(R.drawable.kino1)
                    textView = findViewById(R.id.title_kino1)
                    textView.text = it.title
                    textView = findViewById(R.id.data_kino1)
                    textView.text = it.Datacrete.toString()
                    textView = findViewById(R.id.coment_kino1)
                    textView.text = it.genre
                }
                is Films.kino2 ->{
                    imageView = findViewById(R.id.IV_kino2)
                    imageView.setImageResource(R.drawable.kino2)
                    textView = findViewById(R.id.title_kino2)
                    textView.text = it.title
                    textView = findViewById(R.id.data_kino2)
                    textView.text = it.Datacrete.toString()
                    textView = findViewById(R.id.coment_kino2)
                    textView.text = it.genre
                }
            }
        }

    }
}