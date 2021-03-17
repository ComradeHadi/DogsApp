package com.hadi.dogsapp.data.repository

import com.hadi.dogsapp.data.mappers.DataDogBreedMapper
import com.hadi.dogsapp.data.remotedatasource.ServiceApi
import com.hadi.dogsapp.domain.Repository
import javax.inject.Inject

class RepositoryImplementer @Inject constructor(
    private val serviceApi: ServiceApi,
    private val dogBreedMapper: DataDogBreedMapper
) : Repository {



}
