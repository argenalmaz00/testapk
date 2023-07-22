package com.example.myapplication4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication4.databinding.FragmentListUserBinding

class ListUserFragment : Fragment() {
    private  var _binding : FragmentListUserBinding? = null
    private val binding get() = _binding!!
    private val listUser = ListUser()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentListUserBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createUser()
        chunck_user()
        postData_to_create()

    }

    private fun postData_to_create() {
        parentFragmentManager.setFragmentResultListener(CreateUserFragment.USER_KEY,viewLifecycleOwner)
        { _, bundle: Bundle ->
            val icon = bundle.getString(CreateUserFragment.ICON)
            val name = bundle.getString(CreateUserFragment.NAME)
            val age = bundle.getString(CreateUserFragment.AGE)
            if (icon != null && name != null && age != null){
                listUser.addUser(User(icon,name,age.toInt()))
            }
        }
    }

    private fun chunck_user() {
        binding.rvListUser.adapter = listUser

    }

    private fun createUser() {
        binding.btAdduser.setOnClickListener {
            findNavController()
                .navigate(R.id.action_listUserFragment_to_createUserFragment)
        }
    }
}