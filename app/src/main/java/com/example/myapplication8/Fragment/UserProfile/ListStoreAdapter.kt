package com.example.myapplication8.Fragment.UserProfile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication8.R
import com.example.myapplication8.databinding.LineUserBinding

class ListStoreAdapter :RecyclerView.Adapter<ListStoreAdapter.StoreHolder>() {
    private val listStore = listOf<StoreClass>(
        StoreClass(R.drawable.store_one,"Store1"),
        StoreClass(R.drawable.store_two,"Store2"),
        StoreClass(R.drawable.store_free,"Store3"),
        StoreClass(R.drawable.store_fow,"Store4"),
    )
    class StoreHolder(val binding :LineUserBinding) :RecyclerView.ViewHolder(binding.root){
        fun onCreateStore(storeClass: StoreClass) {
            Glide
                .with(binding.ivIconStore)
                .load(storeClass.icon)
                .placeholder(R.drawable.loadgin)
                .into(binding.ivIconStore)
            binding.tvNameStore.text = storeClass.nameStore
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreHolder {
        val a = LineUserBinding.inflate(LayoutInflater.from(parent.context))
        return StoreHolder(a)
    }

    override fun getItemCount(): Int {
        return listStore.size
    }

    override fun onBindViewHolder(holder: StoreHolder, position: Int) {
        holder.onCreateStore(listStore[position])
    }
}