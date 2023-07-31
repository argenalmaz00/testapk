package com.example.myapplication8.Fragment.MainStore.ListAdapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.myapplication8.R
import com.example.myapplication8.databinding.ActivityTovarOpenBinding

class TovarOpenActivity : AppCompatActivity() {
    private lateinit var binding :ActivityTovarOpenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTovarOpenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intz()
    }

    private fun intz() {

        intent.getBundleExtra(ListAdater.DATA_KEY)?.apply {
            binding.tvNameTovarActivty.text = this.getString(ListAdater.NAME_KEY)
            binding.tvDateActivty.text = this.getString(ListAdater.DATE_KEY)
            binding.tvDiscrtopsActivty.text = this.getString(ListAdater.DESCRIPTIONS_KEY)

            Glide.
                with(binding.ivIconTovarActivty)
                .load(this.getInt(ListAdater.IMAGEURI_KEY))
                .placeholder(R.drawable.loadgin)
                .into(binding.ivIconTovarActivty)

        }
    }
}