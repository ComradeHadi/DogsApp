package com.hadi.dogsapp.presentation.injections


import android.app.Application
import com.hadi.dogsapp.data.injections.RepositoryModule
import com.hadi.dogsapp.data.injections.RetrofitModule
import com.hadi.dogsapp.domain.UseCasesModule
import com.hadi.dogsapp.presentation.DogsAppApplication
import com.hadi.dogsapp.presentation.viewmodels.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelFactory::class,
        ActivityBuilderModule::class,
        RetrofitModule::class,
        RepositoryModule::class,
        UseCasesModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<DogsAppApplication> {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
