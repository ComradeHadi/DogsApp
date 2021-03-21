package com.hadi.dogsapp.data.remotedatasource

import com.hadi.dogsapp.data.models.Breed
import com.hadi.dogsapp.data.models.BreedsApiResp
import com.hadi.dogsapp.data.models.DogApiResponse
import com.hadi.dogsapp.domain.entities.BreedEntity
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {
    @GET("breeds/list/all")
    suspend fun getAllBreeds(): BreedsApiResp

}
