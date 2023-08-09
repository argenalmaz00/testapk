package com.example.myapplication10.ui.Fragments.OnBoards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication10.R
import com.example.myapplication10.databinding.FragmentOnBoardBinding
import com.example.myapplication10.ui.Adapters.OnBoardAdapter


class OnBoardFragment : Fragment() {

    private lateinit var binding :FragmentOnBoardBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOnBoardBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }

    private fun initialize() {
        binding.notesViewPager.apply {
            adapter = OnBoardAdapter(this@OnBoardFragment)
            binding.indicator.attachTo(this)
        }
    }

    private fun setupListener() = with(binding.notesViewPager) {
        registerOnPageChangeCallback (object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.tvSkip.isInvisible = currentItem == 2
            }
        })

        binding.tvSkip.setOnClickListener {
            if (currentItem < 2) {
                setCurrentItem(currentItem + 1, true)
            }
        }
    }
}