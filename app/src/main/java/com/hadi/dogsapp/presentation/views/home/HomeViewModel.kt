package com.hadi.dogsapp.presentation.views.home

import BaseSchedulerProvider
import BaseViewModel
import android.os.AsyncTask.execute
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.hadi.dogsapp.data.mappers.DataDogBreedMapper
import com.hadi.dogsapp.domain.usecases.GetAllBreedsUseCase
import com.hadi.dogsapp.presentation.mapper.DogBreedDataMapper
import com.hadi.dogsapp.presentation.models.BreedUIModel
import com.hadi.dogsapp.presentation.utils.ViewState
import io.reactivex.functions.Consumer
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getAllBreedsUseCase: GetAllBreedsUseCase,
    private val dataDogBreedMapper: DogBreedDataMapper,
    baseSchedulerProvider: BaseSchedulerProvider
) : BaseViewModel(baseSchedulerProvider = baseSchedulerProvider), LifecycleObserver {

    val allBreeds = MutableLiveData<ViewState<List<BreedUIModel>>>()


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun getAlBreeds() {
        execute(loadingConsumer = Consumer {
            allBreeds.postValue(ViewState.loading())
        }, throwableConsumer = Consumer {
            allBreeds.postValue(ViewState.error(it.message))
        }, successConsumer = Consumer {
            allBreeds.postValue(ViewState.success(it.map{
                    post->dataDogBreedMapper.mapFromDomnainToPresnetation(post)}))
        }, useCase = getAllBreedsUseCase.getAllBreeds())
    }
}

