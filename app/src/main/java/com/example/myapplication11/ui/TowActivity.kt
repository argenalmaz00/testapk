package com.example.myapplication11.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication11.utilit.PreferencesHelper
import com.example.myapplication11.databinding.ActivityTowBinding

class TowActivity : AppCompatActivity() {
    private lateinit var binding :ActivityTowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intt()
    }

    private fun intt() {
        val data = PreferencesHelper(this)

        binding.apply {
            tvName.text = data.name
            tvSurname.text = data.surname

        }
    }
}