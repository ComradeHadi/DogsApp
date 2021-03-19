package com.hadi.dogsapp.presentation.views.home

import androidx.lifecycle.ViewModel
import com.hadi.dogsapp.presentation.viewmodels.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindsHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}
