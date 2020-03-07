package com.Mark.mostpopuler.commons.di.moduls


import android.content.Context
import com.Mark.mostpopuler.commons.networking.AppScheduler
import com.Mark.mostpopuler.commons.networking.Scheduler

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val context: Context) {
    @Provides
    @Singleton
    fun providesContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun providescheduler(): Scheduler {
        return AppScheduler()
    }
}