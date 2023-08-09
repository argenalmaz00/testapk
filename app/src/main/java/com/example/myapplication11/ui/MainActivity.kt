package com.example.myapplication11.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication11.utilit.PreferencesHelper
import com.example.myapplication11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        botton()
    }

    private fun botton() {
        val data = PreferencesHelper(this)
        binding.btNext.setOnClickListener {
            data.name = binding.etName.text.toString()
            data.surname = binding.etSurname.text.toString()
            Intent(this, TowActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}