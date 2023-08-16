package com.example.myapplication12.ui

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.example.myapplication12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setImage()
    }

    private val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            binding.ivImage.setImageURI(uri)
        }


    private  fun setImage() {
        var isPermession = false
        binding.ivImage.setOnClickListener {
            if (checkSelfPermission(READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                galleryLauncher.launch("image/*")
            }
            else {
                requestPermissions(arrayOf(READ_EXTERNAL_STORAGE),100)
                if (shouldShowRequestPermissionRationale(READ_EXTERNAL_STORAGE)){
                    Toast.makeText(this,"Permession denied",Toast.LENGTH_SHORT).show()
                    isPermession = true
                }
                else{
                    if (!(checkSelfPermission(READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) && isPermession){
                        Dialog()
                    }
                }
            }
        }
    }

    private fun Dialog(){
        AlertDialog.Builder(this).apply {
            setTitle("Access is denied")
            setMessage("Open Settings, Set Permissions and Storage and Unzip")
            setPositiveButton("Go"){ dialogInterface: DialogInterface, i: Int ->
                openSetting()
            }
            setNegativeButton("Cansel"){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this@MainActivity,"Premession denied",Toast.LENGTH_SHORT).show()
            }
        }.show()
    }

    private fun openSetting(){
        Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            setData(Uri.parse("package:" + packageName.toString()))
            startActivity(this)
        }
    }
}