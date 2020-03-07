package com.Mark.mostpopuler.vacation.vacationlists.di.module

import com.Mark.mostpopuler.vacation.vacationlists.adapter.MostPopulerListAdapter
import com.Mark.mostpopuler.commons.data.remote.MostPopularService
import com.Mark.mostpopuler.commons.networking.Scheduler
import com.Mark.mostpopuler.vacation.vacationlists.di.MostPopulerListScope
import com.Mark.mostpopuler.vacation.vacationlists.model.MostPopulerDataContract
import com.Mark.mostpopuler.vacation.vacationlists.model.MostPopulerRemoteData
import com.Mark.mostpopuler.vacation.vacationlists.model.MostPopulerRepository
import com.Mark.mostpopuler.vacation.vacationlists.viewmodel.MostPopulerViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit

@Module
@MostPopulerListScope
class MostPopulerListModule {



    /*Adapter*/
    @Provides
    @MostPopulerListScope
    fun provideadapter(): MostPopulerListAdapter = MostPopulerListAdapter()

    /*ViewModel*/
    @Provides
    @MostPopulerListScope
    fun providelistViewModelFactory(repository: MostPopulerDataContract.Repository, compositeDisposable: CompositeDisposable): MostPopulerViewModelFactory = MostPopulerViewModelFactory(repository,compositeDisposable)

    /*Repository*/
    @Provides
    @MostPopulerListScope
    fun providelistRepo(remote: MostPopulerDataContract.Remote, scheduler: Scheduler, compositeDisposable: CompositeDisposable): MostPopulerDataContract.Repository = MostPopulerRepository( remote, scheduler, compositeDisposable)

    @Provides
    @MostPopulerListScope
    fun provideremoteData(postService: MostPopularService): MostPopulerDataContract.Remote = MostPopulerRemoteData(postService)

    @Provides
    @MostPopulerListScope
    fun providecompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    @MostPopulerListScope
    fun providepostService(retrofit: Retrofit): MostPopularService = retrofit.create(MostPopularService::class.java)
}