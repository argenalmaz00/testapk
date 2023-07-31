package com.example.myapplication8.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication8.R
import com.example.myapplication8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindong : ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindong = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindong.root)

        val nav = supportFragmentManager.findFragmentById(bindong.fvContener.id) as NavHostFragment
        val navController = nav.navController

        bindong.btNavigationMain.setupWithNavController(navController)
    }
}