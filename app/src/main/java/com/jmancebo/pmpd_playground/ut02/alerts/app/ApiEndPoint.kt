package com.jmancebo.pmpd_playground.ut02.alerts.app

import com.jmancebo.pmpd_playground.ut02.alerts.data.AlertApiModel
import com.jmancebo.pmpd_playground.ut02.alerts.data.EspecificAlertApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint {

    @GET("alerts")
    fun getAlerts(): Call<ResponseApiModel<List<AlertApiModel>>>

    @GET("alerts/{id}")
    fun getAlert(@Path("id") alertId: String): Call<ResponseApiModel<EspecificAlertApiModel>>
}