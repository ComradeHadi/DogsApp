package com.hadi.dogsapp.domain.usecases

import com.hadi.dogsapp.domain.Repository
import javax.inject.Inject

class GetAllBreedsUseCase @Inject constructor(private val repository: Repository) {
    suspend fun getAllBreeds () = repository.getAllBreeds()
}
