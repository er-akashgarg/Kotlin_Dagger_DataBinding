package com.akash.jetpack.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.akash.jetpack.R
import com.akash.jetpack.databinding.ActivityMainBinding
import com.akash.jetpack.model.Post
import com.akash.jetpack.presenter.PostPresenter
import com.akash.jetpack.ui.adapter.PostAdapter
import com.akash.jetpack.views.postview.PostView


/**
 * @author Akash Garg.
 */

class MainActivity : BaseActivity<PostPresenter>(), PostView {

    private lateinit var binding: ActivityMainBinding
    private var postAdapter: PostAdapter = PostAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.adapter = postAdapter
        binding.layoutManager = LinearLayoutManager(this)
        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        presenter.onViewCreated()
    }

    override fun instantiatePresenter(): PostPresenter {
        return PostPresenter(this)
    }

    override fun updatePosts(posts: List<Post>) {
        Log.e("MainActivity:", "---@akash---posts data----> $posts")
        postAdapter.updatePosts(posts)
    }

    @SuppressLint("ShowToast")
    override fun showError(error: String) {
        showToast("Error..")
    }

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }
}
