package com.hadi.dogsapp.domain

import com.hadi.dogsapp.domain.entities.BreedEntity
import io.reactivex.Single

interface Repository {
    fun getAllBreeds(): Single<List<BreedEntity>>
}
