package com.example.myapplication

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemsUserBinding

class Userlist: RecyclerView.Adapter<Userlist.UserView>(){
    private  var users = emptyList <Users>()

    fun setData(list : List<Users>){
        this.users = list
    }
    inner  class  UserView(private val binding:ItemsUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(user :Users)  = with(binding){
            imagesUser.setImageResource(user.id)
            tvName.text = user.name
            tvFamile.text = user.Famile
            tvAge.text = user.age.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserView {
        val items = ItemsUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserView(items)
    }



    override fun onBindViewHolder(holder: UserView, position: Int) {
        holder.onBind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
}