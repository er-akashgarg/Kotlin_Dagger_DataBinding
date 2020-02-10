package com.akash.jetpack.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.akash.jetpack.databinding.ItemPostBinding
import com.akash.jetpack.model.Post

/**
 * @author Akash Garg.
 */

class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post) {
        binding.post = post
        binding.executePendingBindings()
    }
}