package com.example.myapplication8.Fragment.MainStore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication8.Fragment.MainStore.ListAdapter.ListAdater
import com.example.myapplication8.Fragment.MainStore.ListAdapter.Tovar
import com.example.myapplication8.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding :FragmentMainBinding

    private val listAdater = ListAdater()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initz() //initziliton


    }

    private fun initz() {
        startAdapter() //loadData
    }

    private fun startAdapter() {
        binding.rvContenerLineFragment.adapter = listAdater
        binding.rvContenerListFragment.adapter = listAdater
        Tovar().getDataTovar().apply {
            forEach {
                listAdater.addTovar(it)
            }
        }
    }

}