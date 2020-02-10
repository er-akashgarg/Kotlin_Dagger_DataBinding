package com.akash.jetpack.views.postview

import androidx.annotation.StringRes
import com.akash.jetpack.model.Post
import com.akash.jetpack.views.BaseView

interface PostView : BaseView {

    fun updatePosts(posts: List<Post>)

    fun showError(error: String)

    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()
}