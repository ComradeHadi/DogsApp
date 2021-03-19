package com.hadi.dogsapp.data.repository

import com.google.gson.JsonObject
import com.hadi.dogsapp.data.mappers.DataDogBreedMapper
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

//    override fun getAllBreeds(): Single<DogApiResponse> {
//
//        return  serviceApi.getAllBreeds()
//           // .map { response->response.map { postModel -> dogBreedMapper.mapFromDataToDomainModel(postModel) } }
//
//    }

    override suspend fun getAllBreeds() : JsonObject? {
        val dogResponse = safeApiCall(
            call = {serviceApi.getAllBreeds().await()},
            errorMessage = "Error fetching dog breeds"
        )
        return dogResponse?.result
    }
}
