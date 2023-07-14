package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var actitvity: ActivityMainBinding
    private var nuber = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actitvity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(actitvity.root)

        chek_bundle(savedInstanceState)
        button_plus()
    }

    private fun chek_bundle(bundle: Bundle?) {
        bundle?.getString(nuber_save).let {
            if (it != null) {
                nuber = it.toInt()
                actitvity.tvNuber.text = nuber.toString()
            }
            else{
                actitvity.tvNuber.text = nuber.toString()
            }
        }
    }

    private fun button_plus() {
        actitvity.buttonPlus.setOnClickListener {
            nuber++
            if (nuber >= 10){
                Intent(this,TowActivity::class.java).apply {
                    startActivity(this)
                }

            }
            actitvity.tvNuber.text = nuber.toString()

        }
        actitvity.buttonMnus.setOnClickListener {
            nuber--
            if (nuber <= 0){
                nuber++
                Toast.makeText(this,"Disable nuber < 0",Toast.LENGTH_SHORT).show()
            }
            actitvity.tvNuber.text = nuber.toString()
        }
    }

    override fun onSaveInstanceState(bundle: Bundle) {
        super.onSaveInstanceState(bundle)
        bundle.putString(nuber_save,actitvity.tvNuber.text.toString())
    }
    companion object{
        val nuber_save = "nuber_activity"
    }
}