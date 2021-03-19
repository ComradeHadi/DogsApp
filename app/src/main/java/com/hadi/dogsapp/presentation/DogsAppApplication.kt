package com.hadi.dogsapp.presentation

import com.hadi.dogsapp.presentation.injections.AppComponent
import com.hadi.dogsapp.presentation.injections.DaggerAppComponent
import dagger.android.DaggerApplication

class DogsAppApplication : DaggerApplication() {

    override fun applicationInjector(): AppComponent {
        return DaggerAppComponent.builder().application(this).build()
    }
}
