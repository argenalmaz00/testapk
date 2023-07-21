package com.example.myapplication3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication3.databinding.FragmentOneBinding


class OneFragment : Fragment() {
    private var _binding : FragmentOneBinding? = null
    private val binding get () = _binding!!
    val imageList = ImageList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        _binding = FragmentOneBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvContenerFragment.adapter = imageList

        addImage()
    }

    private fun addImage() {
        binding.btGet.setOnClickListener {
            val a =binding.etUri.text.toString()
            imageList.addImage(a)
        }
    }


}