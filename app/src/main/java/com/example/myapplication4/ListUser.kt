package com.example.myapplication4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication4.databinding.PasportUserBinding

class ListUser:RecyclerView.Adapter<ListUser.ListHolder>() {
    private val listUser = ArrayList<User>()
    fun addUser(list:User){
        listUser.add(list)
        notifyDataSetChanged()
    }
    fun delUser(i:Int){
        this.listUser.removeAt(i)
        notifyDataSetChanged()
    }
    inner class ListHolder(private  val bindning:PasportUserBinding):RecyclerView.ViewHolder(bindning.root) {
        fun onCreate(user: User) = with(bindning){
            tvNameUser.text = user.name
            tvAge.text = user.age.toString()

            Glide
                .with(ivIconUser)
                .load(user.icon)
                .placeholder(R.drawable.ic_launcher_background)
                .into(ivIconUser)
            bindning.root.setOnClickListener {
                delUser(adapterPosition)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val a = PasportUserBinding.inflate(LayoutInflater.from(parent.context))
        return  ListHolder(a)
    }


    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.onCreate(this.listUser[position])
    }

    override fun getItemCount(): Int {
        return listUser.size
    }
}