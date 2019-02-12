package com.example.myapplication.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.User
import kotlinx.android.synthetic.main.item_user.view.*

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.Holder>() {

    var data: List<User> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClick: ((User) -> Unit) = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.render(data[position])
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                onItemClick(data[adapterPosition])
            }
        }

        fun render(user: User) {
            itemView.iuserTxtName.text = user.name
        }
    }
}