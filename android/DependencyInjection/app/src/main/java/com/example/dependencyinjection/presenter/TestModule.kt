package com.example.dependencyinjection.presenter

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class TestModule {

    @Binds
    abstract fun bindView(activity: TestView): Mvp.View

    @Binds
    abstract fun bindPresenter(presenter: TestPresenter): Mvp.Presenter

    companion object {
        @Provides
        fun provideTestView(activity: Activity): TestView = activity as TestView

        // @Provides
        // fun provideTestView(fragment: Fragment): TestView = fragment as TestView
    }
}