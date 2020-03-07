package com.Mark.mostpopuler.vacation.vacationlists.model


import com.Mark.mostpopuler.commons.data.remote.MostPopularService
import com.Mark.mostpopuler.constants.Constants
import com.example.mostpopularapp.ui.mplist.models.MostPopularResponseObj
import io.reactivex.Single


class MostPopulerRemoteData(private val mostPopularService: MostPopularService) : MostPopulerDataContract.Remote {

    override fun getMostPopulerList(num: Int): Single<MostPopularResponseObj> {
        return mostPopularService.getMostPopuler(Constants.API_URL+num+".json",Constants.API_KEY)
    }

    }
