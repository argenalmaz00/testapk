package com.example.myapplication


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityTowBinding
import kotlin.random.Random

class TowActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTowBinding
    private  var userlist = Userlist()
    private  val use = listOf<Users>(
        Users(R.drawable.dver_zpili,"Андрей","Кирпич",43),
        Users(R.drawable.sobaki,"Шарик","Без фамиля",16),
        Users(R.drawable.ic_launcher_background,"Зелеёны","Кирпич",43),
        Users(R.drawable.worl_tenks,"Argen","almaz",19),
        Users(R.drawable.xiler_xp,"Модны","Хилер",29),
        Users(R.drawable.srgancat,"Кот","Плконик",43),
        Users(R.drawable.m_install_game,"Сергей","Задрот",13)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTowBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var userss = ArrayList<Users>()
        for (i in 0..10){
            userss.add(use[(Random.nextInt(0,use.size -1 ))])
        }
        userlist.setData(userss)
        binding.rvVi.adapter = userlist

    }
}
