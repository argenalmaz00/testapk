package com.example.myapplication10.ui.Fragments.NotesEdit

import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication10.R
import com.example.myapplication10.databinding.FragmentNoteEditBinding
import com.example.myapplication10.ui.App
import com.example.myapplication9.DataSave.models.NoteModel
import java.text.SimpleDateFormat
import java.util.Date

class NoteEditFragment : Fragment() {

    private lateinit var binding :FragmentNoteEditBinding
    private val date =  SimpleDateFormat("dd MMM").format(Date())
    private val time = SimpleDateFormat("HH:m").format(Date())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentNoteEditBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDateView()
        dataSaveText()
    }

    private fun dataSaveText()= with(binding) {
        btSave.setOnClickListener{
            if (editText.text.isNotEmpty() && editTitle.text.isNotEmpty()){
                App.getInstance()?.noteDao()?.insertAll(
                    NoteModel(
                        editTitle.text.toString(),
                        editText.text.toString(),
                        date,
                        time
                    ))
                findNavController().navigateUp()
            }
        }
        btBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setDateView() = with(binding){
        tvDate.text = date
        tvTime.text = time
    }
}