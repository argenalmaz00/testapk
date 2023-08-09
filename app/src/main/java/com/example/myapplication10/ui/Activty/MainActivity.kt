package com.example.myapplication10.ui.Activty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplication10.R
import com.example.myapplication10.databinding.ActivityMainBinding
import com.example.myapplication10.ui.App
import com.example.myapplication10.ui.data.dp.daos.NoteDao
import com.example.myapplication10.ui.utils.PreferenceHelper

class MainActivity : AppCompatActivity(){

    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        val ishello = PreferenceHelper(this).isHello
        if (!ishello){
            navGraph.setStartDestination(R.id.onBoardFragment)
        }
        else{
            navGraph.setStartDestination(R.id.notesFragment)
        }
        navController.graph = navGraph
    }
}