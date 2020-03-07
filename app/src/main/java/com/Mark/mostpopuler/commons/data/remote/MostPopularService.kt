package com.Mark.mostpopuler.commons.data.remote



import com.example.mostpopularapp.ui.mplist.models.MostPopularResponseObj
import io.reactivex.Single
import retrofit2.http.*

interface MostPopularService {

    @GET()
    fun getMostPopuler(@Url url: String?, @Query("api-key") query: String?): Single<MostPopularResponseObj>

}