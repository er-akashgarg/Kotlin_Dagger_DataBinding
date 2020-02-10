package com.akash.jetpack.ui.activity

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.akash.jetpack.presenter.BasePresenter
import com.akash.jetpack.views.BaseView


/**
 * @param P the type of the presenter the Activity is based on
 */

/**
 * @author Akash Garg.
 */

abstract class BaseActivity<P : BasePresenter<BaseView>> : AppCompatActivity(), BaseView {

    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()
    }

    protected abstract fun instantiatePresenter(): P

    override fun getContext(): Context {
        return this
    }

    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}