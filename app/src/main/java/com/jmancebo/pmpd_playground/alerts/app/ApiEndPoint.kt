package com.jmancebo.pmpd_playground.alerts.app

import com.jmancebo.pmpd_playground.alerts.data.AlertApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {

    @GET("alerts")
    fun getAlerts(): Call<ResponseApiModel<List<AlertApiModel>>>
}