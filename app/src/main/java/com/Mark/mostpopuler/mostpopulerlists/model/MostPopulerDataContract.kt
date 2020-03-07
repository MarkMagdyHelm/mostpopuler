package com.Mark.mostpopuler.vacation.vacationlists.model

import com.Mark.mostpopuler.utils.SingleLiveEvent
import com.example.mostpopularapp.ui.mplist.models.MostPopularResponseObj
import io.reactivex.Single


interface MostPopulerDataContract {

    interface Repository {
        val mostPopulerFailerCallBacks : SingleLiveEvent<String>
        val mostPopulerCallBacks : SingleLiveEvent<MostPopularResponseObj>
        fun getMostPopulerList(num: Int)
    }

    interface Remote {
        fun getMostPopulerList(num: Int): Single<MostPopularResponseObj>


    }
}