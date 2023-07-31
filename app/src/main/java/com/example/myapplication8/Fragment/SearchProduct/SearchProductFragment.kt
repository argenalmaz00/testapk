package com.example.myapplication8.Fragment.SearchProduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication8.Fragment.MainStore.ListAdapter.ListAdater
import com.example.myapplication8.Fragment.MainStore.ListAdapter.Tovar
import com.example.myapplication8.R
import com.example.myapplication8.databinding.FragmentSearchProductBinding


class SearchProductFragment : Fragment() {
    private lateinit var binding: FragmentSearchProductBinding
    private val list = ListAdater()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding =  FragmentSearchProductBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvContenerLineFragment.adapter = list
        Tovar().getDataTovar().apply {
            forEach {
                list.addTovar(it)
            }
        }
    }


}