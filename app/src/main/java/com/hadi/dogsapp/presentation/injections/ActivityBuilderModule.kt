package com.hadi.dogsapp.presentation.injections

import com.hadi.dogsapp.presentation.views.home.HomeActivity
import com.hadi.dogsapp.presentation.views.home.HomeViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [HomeViewModelModule::class])
    internal abstract fun bindsHomeActivity(): HomeActivity

//    @ContributesAndroidInjector
//    internal abstract fun bindsMainActivity(): MainActivity
}
