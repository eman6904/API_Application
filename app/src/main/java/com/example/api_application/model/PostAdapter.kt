package com.example.api_application.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.api_application.databinding.PostModelBinding

class PostAdapter(private val list: List<Post>) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: PostModelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val userId = binding.userId
        val id = binding.id
        val title = binding.title
        val body = binding.body
        val count = binding.count
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PostModelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.count.text = (position + 1).toString()
        holder.userId.text = list[position].userId.toString()
        holder.id.text = list[position].id.toString()
        holder.title.text = list[position].title
        holder.body.text = list[position].body
    }

    override fun getItemCount(): Int {
        return list.size
    }
}