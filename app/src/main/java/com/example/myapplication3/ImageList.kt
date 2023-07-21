package com.example.myapplication3

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication3.databinding.ActivityMainBinding
import com.example.myapplication3.databinding.ItemsImageBinding

class ImageList:RecyclerView.Adapter<ImageList.ImageHolder>() {
    private val listImage = ArrayList<String>()
    fun addImage(image: String){
        this.listImage.add(image)
        notifyDataSetChanged()
    }
    fun delImage(i :Int){
        this.listImage.removeAt(i)
        notifyDataSetChanged()
    }

    inner class ImageHolder(var binding: ItemsImageBinding):RecyclerView.ViewHolder(binding.root) {
        fun onCreateList(image: String) {
            Glide
                .with(binding.ivImage)
                .load(image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivImage)
            binding.ivImage.setOnLongClickListener {
                delImage(adapterPosition)
                false
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val it = ItemsImageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ImageHolder(it)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.onCreateList(listImage[position])
    }
    override fun getItemCount(): Int {
        return this.listImage.size
    }
}