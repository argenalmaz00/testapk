package com.example.myapplication8.Fragment.UserProfile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication8.R
import com.example.myapplication8.databinding.FragmentUserProfileBinding

class UserProfileFragment : Fragment() {
    private lateinit var binding :FragmentUserProfileBinding
    private val list = ListStoreAdapter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUserProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvContenerStore.adapter = list
    }

}