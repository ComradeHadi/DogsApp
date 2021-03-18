package com.hadi.kwg.presentation.mapper

interface DomainToPresentationMapper<R,E> {
    fun mapFromDomnainToPresnetation(model: R): E
}