package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class TowActivity : AppCompatActivity() {
    private  lateinit var activity : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activity.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.avs,items_Fragment::class.java,null)
            .commit()
    }
}