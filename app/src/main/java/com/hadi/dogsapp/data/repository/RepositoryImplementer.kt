package com.hadi.dogsapp.data.repository

import com.google.gson.JsonObject
import com.hadi.dogsapp.data.mappers.DataDogBreedMapper
import com.hadi.dogsapp.data.models.Breed
import com.hadi.dogsapp.data.models.DogApiResponse
import com.hadi.dogsapp.data.remotedatasource.ServiceApi
import com.hadi.dogsapp.domain.Repository
import com.hadi.dogsapp.domain.entities.BreedEntity
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class RepositoryImplementer @Inject constructor(
    private val serviceApi: ServiceApi,
    private val dogBreedMapper: DataDogBreedMapper
) : Repository , BaseRepository(){


    override suspend fun getAllBreeds(): List<BreedEntity> = serviceApi.getAllBreeds().result.entries.map { (breed, subBreeds) ->
        dogBreedMapper.mapFromDataToDomainModel(
        Breed(breed, subBreeds)
        )

    }

}
