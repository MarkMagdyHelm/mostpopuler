package com.Mark.mostpopuler.vacation.vacationlists.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.Mark.mostpopuler.vacation.vacationlists.model.MostPopulerDataContract
import io.reactivex.disposables.CompositeDisposable

@Suppress("UNCHECKED_CAST")
class MostPopulerViewModelFactory(private val repository: MostPopulerDataContract.Repository, private val compositeDisposable: CompositeDisposable) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MostPopulerViewModel(repository, compositeDisposable) as T
    }
}