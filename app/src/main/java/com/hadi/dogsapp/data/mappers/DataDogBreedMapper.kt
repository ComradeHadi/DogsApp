package com.hadi.dogsapp.data.mappers

import com.hadi.dogsapp.data.models.Breed
import com.hadi.dogsapp.domain.entities.BreedEntity

class DataDogBreedMapper : DataToDomainMapper<Breed, BreedEntity>{

    override fun mapFromDataToDomainModel(model: Breed): BreedEntity {

        return BreedEntity(
            name = model.name,
            subBreeds =  model.subBreeds
        )
    }
}
