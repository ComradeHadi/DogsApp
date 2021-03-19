package com.hadi.dogsapp.data.injections

import com.hadi.dogsapp.data.mappers.DataDogBreedMapper
import com.hadi.dogsapp.data.remotedatasource.ServiceApi
import com.hadi.dogsapp.data.repository.RepositoryImplementer
import com.hadi.dogsapp.domain.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideDogBreedMapper() = DataDogBreedMapper()

    @Singleton
    @Provides
    fun providesPostsRepository(service: ServiceApi, dogBreedMapper: DataDogBreedMapper): Repository {
        return RepositoryImplementer(serviceApi = service, dogBreedMapper = dogBreedMapper)
    }
}
