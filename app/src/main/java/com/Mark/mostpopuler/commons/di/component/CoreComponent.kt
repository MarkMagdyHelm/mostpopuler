package com.Mark.mostpopuler.commons.di.component

import android.content.Context
import com.Mark.mostpopuler.commons.networking.Scheduler
import com.Mark.mostpopuler.commons.di.moduls.AppModule
import com.Mark.mostpopuler.commons.di.moduls.NetworkModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface CoreComponent {

    fun context(): Context

    fun retrofit(): Retrofit

    fun scheduler(): Scheduler

}