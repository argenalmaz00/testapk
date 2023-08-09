package com.example.myapplication10.ui.Fragments.OnBoards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication10.R
import com.example.myapplication10.databinding.FragmentOnBoardPagingBinding
import com.example.myapplication10.ui.utils.PreferenceHelper


class OnBoardPagingFragment : Fragment() {

    private lateinit var binding :FragmentOnBoardPagingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding = FragmentOnBoardPagingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        getStarted()
    }

    private fun initialize() = with(binding){
        when(requireArguments().getInt(KEY_ONBOARD)){
            0->{
                animation.setAnimation(R.raw.first)
                tvDescription.text = "Very handy functionality"
            }
            1->{
                animation.setAnimation(R.raw.second)
                tvDescription.text = "Fast,quality product"
            }
            2->{
                animation.setAnimation(R.raw.third)
                tvDescription.text = "Tons of features and cool features"
                tvStart.text= "Get Stared"
            }
        }
    }

    private fun getStarted() = with(binding){
        tvStart.setOnClickListener{
            val preferenceHelper = PreferenceHelper(requireContext())
            preferenceHelper.isHello = true
            findNavController().navigate(R.id.action_onBoardFragment_to_notesFragment)
        }
    }

    companion object{
        const val KEY_ONBOARD = "key_Onboard"
    }
}