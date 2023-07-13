package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activity: ActivityMainBinding
    private  var nuber = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activity.root)



        val nubers = savedInstanceState?.getString(text_nuber)
        if (nubers != null){
            activity.tvNuber.text = nubers.toString()
            nuber = nubers.toInt()
        }else {
            activity.tvNuber.text = nuber.toString()
        }
        setnuber()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(text_nuber,activity.tvNuber.text.toString())
    }

    private fun setnuber() {
        activity.plus.setOnClickListener {
            nuber += 1
            activity.tvNuber.text = nuber.toString()
            if (nuber >= 10){
                Intent(this,TowActivity::class.java).apply{
                    startActivity(this)
                }

            }
        }
        activity.minus.setOnClickListener {
            nuber -= 1
            activity.tvNuber.text = nuber.toString()
            if (-1 >= nuber ){
                nuber += 1
                activity.tvNuber.text = nuber.toString()
                Toast.makeText(this,"low nuber disable",Toast.LENGTH_SHORT).show()
            }
        }
    }
    companion object {
        val text_nuber = "tv_nuber"
    }
}