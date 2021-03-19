package com.hadi.dogsapp.presentation.viewmodels

import io.reactivex.Scheduler

interface BaseSchedulerProvider {

    fun io(): Scheduler

    fun ui(): Scheduler

}
