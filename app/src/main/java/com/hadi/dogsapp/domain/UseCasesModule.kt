package com.hadi.dogsapp.domain

import com.hadi.dogsapp.data.injections.RepositoryModule
import com.hadi.dogsapp.domain.usecases.GetAllBreedsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [RepositoryModule::class])

class UseCasesModule {

    @Singleton
    @Provides
    fun provideGetAllBreedsUseCase(repository: Repository) = GetAllBreedsUseCase(repository = repository)

}
