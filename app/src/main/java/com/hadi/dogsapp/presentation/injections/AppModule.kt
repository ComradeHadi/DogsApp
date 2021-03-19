package com.hadi.dogsapp.presentation.injections


import com.hadi.dogsapp.presentation.mapper.DogBreedDataMapper
import com.hadi.dogsapp.presentation.viewmodels.BaseSchedulerProvider
import com.hadi.dogsapp.presentation.viewmodels.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun providesTaskBaseScheduler(): BaseSchedulerProvider =
        SchedulerProvider()

    @Singleton
    @Provides
    fun providesDogBreedMapper() = DogBreedDataMapper()
}
