package com.hadi.dogsapp.data.mappers

interface DataToDomainMapper<R,E> {
    fun mapFromDataToDomainModel(model: R): E
}
