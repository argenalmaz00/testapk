package com.example.myapplication4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication4.databinding.FragmentCheckUserBinding
import com.example.myapplication4.databinding.PasportUserBinding


class CheckUserFragment : Fragment() {
    private var _binding : FragmentCheckUserBinding? = null
    private val bindning get () = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {

        _binding = FragmentCheckUserBinding.inflate(inflater)
        return bindning.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        if (arguments != null){
            Log.e("start","start")
            data_send_pasport(arguments)
            setButton()
        }
    }

    private fun setButton() {
        bindning.btCreateUser.setOnClickListener {
            arguments?.let {
                parentFragmentManager.setFragmentResult(CreateUserFragment.USER_KEY, it)
                findNavController().navigateUp()
            }

        }
        bindning.btBackPossport.setOnClickListener {
            findNavController().navigateUp()
        }
        bindning.btCancelCreate.setOnClickListener {

        }
    }


    private fun data_send_pasport(bundle: Bundle?)  {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fcv_passport,pas_cheker::class.java,bundle)
            .commit()
    }

    companion object{
        const val KEY_DATA = "KEY_DATA"

    }

}