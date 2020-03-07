package com.Mark.mostpopuler.vacation.vacationlists.di

import com.Mark.mostpopuler.application.BaseApp
import com.Mark.mostpopuler.vacation.vacationlists.di.component.DaggerMostPopulerListComponent

import com.Mark.mostpopuler.vacation.vacationlists.di.component.MostPopulerListComponent
import javax.inject.Singleton

@Singleton
object MostPopulerListDH {
    private var listComponent: MostPopulerListComponent? = null

    fun listComponent(): MostPopulerListComponent {
        if (listComponent == null)
            listComponent = DaggerMostPopulerListComponent.builder().coreComponent(
                BaseApp
                .coreComponent).build()
        return listComponent as MostPopulerListComponent
    }

    fun destroyListComponent() {
        listComponent = null
    }

}