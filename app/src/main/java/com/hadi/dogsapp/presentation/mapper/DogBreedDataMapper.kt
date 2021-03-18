package com.hadi.dogsapp.presentation.mapper

import com.hadi.dogsapp.data.mappers.DataToDomainMapper
import com.hadi.dogsapp.data.models.Breed
import com.hadi.dogsapp.domain.entities.BreedEntity
import com.hadi.dogsapp.presentation.models.BreedUIModel
import com.hadi.kwg.presentation.mapper.DomainToPresentationMapper

class DogBreedDataMapper : DomainToPresentationMapper<BreedEntity, BreedUIModel> {

    override fun mapFromDomnainToPresnetation(model: BreedEntity): BreedUIModel {

        return BreedUIModel(
            name = model.name,
            subBreedsNumber =  1
        )
    }
}
