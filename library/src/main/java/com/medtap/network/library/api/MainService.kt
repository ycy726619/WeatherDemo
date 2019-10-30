package com.medtap.network.library.api

import com.medtap.network.library.basemodel.BaseModel
import com.medtap.network.library.data.HCDTO
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query

interface MainService {

    @GET("weather_mini")
    fun test(@Query("city") city:String): Observable<BaseModel<HCDTO>>

}
