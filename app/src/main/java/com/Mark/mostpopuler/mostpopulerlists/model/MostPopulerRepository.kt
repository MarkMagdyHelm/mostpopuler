package com.Mark.mostpopuler.vacation.vacationlists.model

import com.Mark.mostpopuler.commons.extensions.addTo
import com.Mark.mostpopuler.commons.extensions.performOnBackOutOnMain
import com.Mark.mostpopuler.commons.networking.Scheduler
import com.Mark.mostpopuler.utils.SingleLiveEvent
import com.example.mostpopularapp.ui.mplist.models.MostPopularResponseObj
import io.reactivex.disposables.CompositeDisposable

class MostPopulerRepository(

    val remote: MostPopulerDataContract.Remote,
    private val scheduler: Scheduler,
    private val compositeDisposable: CompositeDisposable

) : MostPopulerDataContract.Repository {
    override val mostPopulerCallBacks: SingleLiveEvent<MostPopularResponseObj> = SingleLiveEvent()
    override val mostPopulerFailerCallBacks: SingleLiveEvent<String> = SingleLiveEvent()



    override fun getMostPopulerList(vacationPostObj: Int){
        remote.getMostPopulerList(vacationPostObj).performOnBackOutOnMain(scheduler)
            .subscribe({ res ->
                if (res != null) {
                    if (res.results!!.size!! < 0) {
                        mostPopulerFailerCallBacks.postValue("error")
                        //post fail callback

                    } else {
                        if (res.results!!.size!! > 0) {
                            //success
                            mostPopulerCallBacks.postValue(res)

                        } else {
                            //fail
                            mostPopulerFailerCallBacks.postValue("error")

                        }
                    }
                } else {
                    //fail
                    mostPopulerFailerCallBacks.postValue("Login failed")

                }

            },
                {


                })
            .addTo(compositeDisposable)


    }

}