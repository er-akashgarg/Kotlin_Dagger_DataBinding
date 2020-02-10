package com.akash.jetpack.injection.module

import android.app.Application
import android.content.Context
import com.akash.jetpack.views.BaseView
import dagger.Module
import dagger.Provides


/**
 * Module which provides all required dependencies about Context
 */

@Module
object ContextModule {

    @Provides
    @JvmStatic
    internal fun provideContext(baseView: BaseView): Context {
        return baseView.getContext()
    }

    internal fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }
}