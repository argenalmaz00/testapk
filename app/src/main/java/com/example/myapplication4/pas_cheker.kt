package com.example.myapplication4

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myapplication4.databinding.PasportUserBinding

class pas_cheker: Fragment() {
    private var _binding: PasportUserBinding? = null
    private  val  bindning get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = PasportUserBinding.inflate(inflater)
        return bindning.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null){
            postData(arguments)

        }
        else{
            Log.e("pas_checker","Not bundel")
        }

    }


    private fun postData(bundel :Bundle?) = with(bundel) {
        val name = this?.getString(CreateUserFragment.NAME)
        val age =  this?.getString(CreateUserFragment.AGE)
        val icon = this?.getString(CreateUserFragment.ICON)

        bindning.tvNameUser.text = name
        bindning.tvAge.text = age

        Glide
            .with(bindning.ivIconUser)
            .load(icon)
            .placeholder(R.drawable.ic_launcher_background)
            .into(bindning.ivIconUser)
    }
}