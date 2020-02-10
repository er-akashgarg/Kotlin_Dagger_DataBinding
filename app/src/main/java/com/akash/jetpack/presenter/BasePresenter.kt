package com.akash.jetpack.presenter

import com.akash.jetpack.injection.component.DaggerPresenterInjector
import com.akash.jetpack.injection.component.PresenterInjector
import com.akash.jetpack.injection.module.ContextModule
import com.akash.jetpack.injection.module.NetworkModule
import com.akash.jetpack.views.BaseView

abstract class BasePresenter<out V : BaseView>(protected val view: V) {


    /**
     * The injector used to inject required dependencies
     */

    private val injector: PresenterInjector = DaggerPresenterInjector
        .builder()
        .baseView(view)
        .contextModule(ContextModule)
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated() {

    }


    open fun onViewDestroyed() {

    }

    /**
     * Injects the required dependencies
     */

    private fun inject() {
        when (this) {
            is PostPresenter
            -> injector.inject(this)
        }
    }
}