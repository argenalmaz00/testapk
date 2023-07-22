package com.example.myapplication4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication4.databinding.FragmentCreateUserBinding


class CreateUserFragment : Fragment() {
    private var _bindning : FragmentCreateUserBinding? = null
    private val bindning get()  = _bindning!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _bindning = FragmentCreateUserBinding.inflate(inflater,container,false)
        return bindning.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data()

    }

    private fun data() {
        bindning.btCreateUser.setOnClickListener {
            with(bindning){
                val name = etName.text.toString()
                val age = etAge.text.toString()
                val icon = etIconImage.text.toString()
                if (name != null && age != null){
                    Bundle().apply {
                        Log.e("Create","send Data checker")
                        this.putString(NAME,name)
                        this.putString(ICON,icon)
                        this.putString(AGE,age)
                        findNavController()
                            .navigate(R.id.action_createUserFragment_to_checkUserFragment,this)
                    }
                }
                else {
                    Log.e("Create","Not send Data")
                }
            }
        }
    }

    companion object{
        const val USER_KEY = "Key_user"
        const val ICON = "icon"
        const val NAME = "name"
        const val AGE = "age"
    }

}