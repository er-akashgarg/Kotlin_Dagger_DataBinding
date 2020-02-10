package com.akash.jetpack.presenter

import android.util.Log
import com.akash.jetpack.R
import com.akash.jetpack.network.ApisCalls
import com.akash.jetpack.views.postview.PostView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostPresenter(var postView: PostView) : BasePresenter<PostView>(postView) {

    @Inject
    lateinit var postApisCalls: ApisCalls

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadData()
    }

    private fun loadData() {
        Log.e("--------", "------load Data() ----")
        postView.showLoading()
        subscription = postApisCalls
            .getPosts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { postView.hideLoading() }
            .subscribe(
                { postList ->
                    Log.e("--------", "--22----load Daat() ----$postList")
                    postView.showLoading()
                    postView.updatePosts(postList)
                },
                { postView.showError(R.string.error) }
            )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

}