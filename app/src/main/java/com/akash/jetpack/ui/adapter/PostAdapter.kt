package com.akash.jetpack.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.akash.jetpack.R
import com.akash.jetpack.databinding.ItemPostBinding
import com.akash.jetpack.model.Post

/**
 * @author Akash Garg.
 */

class PostAdapter(private val context: Context) : RecyclerView.Adapter<PostViewHolder>() {

    private var postLists: List<Post> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemPostBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_post, parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postLists.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postLists[position])
    }

    /**
     * Updates the list of posts of the adapter
     * @param posts the new list of posts of the adapter
     */

    fun updatePosts(post: List<Post>) {
        this.postLists = post
        notifyDataSetChanged()
    }
}