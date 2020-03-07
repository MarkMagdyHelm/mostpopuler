package com.Mark.mostpopuler.vacation.vacationlists.viewmodel


import androidx.lifecycle.ViewModel
import com.Mark.mostpopuler.utils.SingleLiveEvent
import com.Mark.mostpopuler.vacation.vacationlists.model.MostPopulerDataContract
import com.example.mostpopularapp.ui.mplist.models.MostPopularResponseObj
import io.reactivex.disposables.CompositeDisposable


class MostPopulerViewModel(
    private val repo: MostPopulerDataContract.Repository,
    private val compositeDisposable: CompositeDisposable
) : ViewModel() {
//
    fun fetchMostPopulerList(num : Int)
    {
        return repo.getMostPopulerList(num)
    }

    fun mostPopulerCallBack(): SingleLiveEvent<MostPopularResponseObj>
    {
        return repo.mostPopulerCallBacks
    }


    override fun onCleared() {
        super.onCleared()
        //clear the disposables when the com.Mark.mostpopuler.home.viewmodel is cleared
        compositeDisposable.clear()
//        PostDH.destroyListComponent()
    }

}