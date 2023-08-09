package com.example.myapplication10.ui.Fragments.Notes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication10.R
import com.example.myapplication10.databinding.FragmentNotesBinding
import com.example.myapplication10.ui.Adapters.NotesAdapter
import com.example.myapplication10.ui.App


class NotesFragment : Fragment() {

    private lateinit var binding: FragmentNotesBinding
    private val notesAdapter = NotesAdapter()

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentNotesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        intz()
        noteCreate()
    }

    private fun noteCreate() {
        binding.btAddNote.setOnClickListener {
            findNavController().navigate(R.id.action_notesFragment_to_noteEditFragment)
        }
    }

    private fun intz() {
        App.getInstance()?.noteDao()?.getAll()?.observe(viewLifecycleOwner){
            notesAdapter.loadData_Array(it)
        }

        binding.rvContener.adapter = notesAdapter
    }


}