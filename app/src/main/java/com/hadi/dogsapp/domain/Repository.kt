package com.hadi.dogsapp.domain

import com.google.gson.JsonObject
import com.hadi.dogsapp.data.models.DogApiResponse
import com.hadi.dogsapp.domain.entities.BreedEntity
import io.reactivex.Single

interface Repository {
    suspend fun getAllBreeds() : JsonObject?
}
