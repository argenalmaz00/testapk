package com.example.myapplication10.ui.Adapters

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication10.ui.Fragments.OnBoards.OnBoardPagingFragment

class OnBoardAdapter(fragment: Fragment) :FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = OnBoardPagingFragment().apply {
        arguments = Bundle().apply {
            putInt(OnBoardPagingFragment.KEY_ONBOARD,position)
        }
    }
}