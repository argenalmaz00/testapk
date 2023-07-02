package com.example.androidinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        geter()
        wifi()
    }

    fun wifi(){
        val butt:Button = findViewById(R.id.bt_connect)
        val pass:EditText = findViewById(R.id.et_password)
        butt.setOnClickListener {
            var pas:String  = pass.text.toString()
            Phone().WiFi().connect(pas){
                if (it){
                    Toast.makeText(this,"Connect",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Fail",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun geter(){
        val Model:TextView = findViewById(R.id.tv_Model_name)
        val Ram:TextView = findViewById(R.id.tv_Ram)
        val Memory:TextView = findViewById(R.id.tv_Memory)

        val butt:Button = findViewById(R.id.bt_GetInfo)
        butt.setOnClickListener{
            Phone().GetInfo { model, ram, memory ->
                Model.text = ("Model:"+ model)
                Ram.text = ("Ram: " + ram.toString() + " G")
                Memory.text = ("Memory: " + memory.toString() + " G")
            }
        }
    }
}