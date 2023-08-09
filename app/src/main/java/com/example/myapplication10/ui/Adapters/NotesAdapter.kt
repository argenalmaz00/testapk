package com.example.myapplication10.ui.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication10.databinding.LineNoteBinding

import com.example.myapplication9.DataSave.models.NoteModel

class NotesAdapter :RecyclerView.Adapter<NotesAdapter.NotesHolder>() {

    private var listNotes:List<NoteModel> = ArrayList<NoteModel>()

    fun loadData_Array(list :List<NoteModel>){
        this.listNotes = list
        notifyDataSetChanged()
    }

    inner class NotesHolder(val binding :LineNoteBinding) :RecyclerView.ViewHolder(binding.root) {
        fun LineNote(noteClass: NoteModel) = with(binding) {
            title.text = noteClass.title
            descritions.text =  noteClass.text
            time.text = noteClass.time
            date.text = noteClass.date
            intz()
        }

        private fun intz() {
            binding.root.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesHolder {
        return NotesHolder(LineNoteBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = listNotes.size


    override fun onBindViewHolder(holder: NotesHolder, position: Int) {
        holder.LineNote(listNotes[position])
    }
}