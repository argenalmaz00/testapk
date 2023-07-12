package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityTowBinding

class TowActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTowBinding
    private  var userlist = Userlist()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTowBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var userss = listOf<Users>(
            Users(0,"test","fmaily",20),Users(0,"test","fmaily",20),Users(0,"test","fmaily",20)
        )
        userlist.setData(userss)
        binding.rvVi.adapter = userlist

    }
}
