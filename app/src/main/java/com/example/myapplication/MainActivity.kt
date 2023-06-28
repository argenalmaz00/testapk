package com.example.myapplication

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private var films = arrayListOf<Films>(Films.BLOCK_ONE(R.drawable.kino1,"Страные кино",2012,"Без понятно описания"),
        Films.BLOCK_TWO(R.drawable.kino2,"хотя бы в кино",2015,"Без понятно"))


    private var blockOne = arrayListOf<Int>(R.id.iv_block_one,R.id.tv_title_video_one,R.id.tv_data_video_one,R.id.coment_video_one)
    private  var blockTwo = arrayListOf<Int>(R.id.iv_block_two,R.id.tv_title_video_two,R.id.tv_data_video_two,R.id.coment_video_two)
    lateinit var  TextView: TextView
    lateinit var  ImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        films.forEach {
            when(it){
                is Films.BLOCK_ONE ->{
                    ImageView = findViewById(blockOne.get(0))
                    ImageView.setImageResource(it.imagedrawable)
                    for (i in 1..3){
                        TextView = findViewById(blockOne.get(i))
                        if (i == 1) TextView.text = it.title
                        else if (i == 2) TextView.text = it.datacrete.toString()
                        else if (i == 3) TextView.text = it.genre
                    }
                }
                is Films.BLOCK_TWO ->{
                    ImageView = findViewById(blockTwo.get(0))
                    ImageView.setImageResource(it.imagedrawable)
                    for (i in 1..3){
                        TextView = findViewById(blockTwo.get(i))
                        if (i == 1) TextView.text = it.title
                        else if (i == 2) TextView.text = it.datacrete.toString()
                        else if (i == 3) TextView.text = it.genre

                    }

                }

            }
        }

    }
}