package com.jmancebo.pmpd_playground.ut02.alerts.app

import com.jmancebo.pmpd_playground.ut02.alerts.data.AlertApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {

    @GET("alerts")
    fun getAlerts(): Call<ResponseApiModel<List<AlertApiModel>>>
}