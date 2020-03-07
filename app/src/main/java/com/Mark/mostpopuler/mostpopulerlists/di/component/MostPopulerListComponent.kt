package com.Mark.mostpopuler.vacation.vacationlists.di.component

import com.Mark.mostpopuler.commons.data.remote.MostPopularService
import com.Mark.mostpopuler.commons.di.component.CoreComponent
import com.Mark.mostpopuler.commons.networking.Scheduler
import com.Mark.mostpopuler.vacation.vacationlists.di.MostPopulerListScope
import com.Mark.mostpopuler.vacation.vacationlists.di.module.MostPopulerListModule
import com.Mark.mostpopuler.vacation.vacationlists.view.MostPopulerListsActivity
import dagger.Component

@MostPopulerListScope
@Component(dependencies = [CoreComponent::class], modules = [MostPopulerListModule::class])
interface MostPopulerListComponent {

    //Expose to dependent components

    fun getVacationAsRequest(): MostPopularService

    fun scheduler(): Scheduler

    fun inject(mostPopulerRequest: MostPopulerListsActivity)

}

