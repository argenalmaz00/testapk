package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startFragment()
    }

    private fun startFragment() {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.tow_content_fragment,BlankFragment2())
            .commit()



        supportFragmentManager.beginTransaction()
            .replace(R.id.moy_content_fragment,BlankFragment())
            .commit()
    }
}