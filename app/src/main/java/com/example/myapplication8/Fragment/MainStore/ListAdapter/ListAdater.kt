package com.example.myapplication8.Fragment.MainStore.ListAdapter

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication8.R
import com.example.myapplication8.databinding.LineTovarBinding

class ListAdater :RecyclerView.Adapter<ListAdater.TovarHolder>() {
    private val listTovar = ArrayList<TovarClass>()

    fun addTovar(tovarClass: TovarClass){
        this.listTovar.add(tovarClass)
        this.notifyDataSetChanged()
    }

    class TovarHolder(val binding :LineTovarBinding) :RecyclerView.ViewHolder(binding.root){
        private lateinit var tovarClassa: TovarClass
        fun TovarChang(tovarClass: TovarClass) {
            tovarClassa = tovarClass
            binding.tvNameTovar.text = tovarClass.name
            Glide
                .with(binding.ivIconTovar)
                .load(tovarClass.imageUri)
                .placeholder(R.drawable.loadgin)
                .into(binding.ivIconTovar)

            intz()
        }

        private fun intz() {
            binding.root.setOnClickListener {
                Intent(this.binding.root.context,TovarOpenActivity::class.java).apply {
                    putExtra(DATA_KEY,packegData())
                    binding.root.context.startActivity(this)
                }

            }
        }

        private fun packegData() :Bundle {
            val a = Bundle().apply {
                putInt(IMAGEURI_KEY , tovarClassa.imageUri)
                putString(NAME_KEY,tovarClassa.name)
                putString(DATE_KEY,tovarClassa.Date)
                putString(DESCRIPTIONS_KEY,tovarClassa.descriptions)
            }

            return a
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TovarHolder {
        val bind = LineTovarBinding.inflate(LayoutInflater.from(parent.context))
        return  TovarHolder(bind)
    }

    override fun getItemCount(): Int {
        return  this.listTovar.size
    }

    override fun onBindViewHolder(holder: TovarHolder, position: Int) {
        holder.TovarChang(this.listTovar[position])
    }
    companion object{
        const val DATA_KEY = "data_key"
        const val IMAGEURI_KEY = "image_key"
        const val NAME_KEY =  "name_key"
        const val DATE_KEY ="Date_key"
        const val DESCRIPTIONS_KEY ="descriptions_key"

    }
}