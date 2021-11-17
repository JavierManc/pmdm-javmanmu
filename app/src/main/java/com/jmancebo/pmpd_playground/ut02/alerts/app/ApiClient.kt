package com.jmancebo.pmpd_playground.ut02.alerts.app

import com.jmancebo.pmpd_playground.ut02.alerts.data.AlertApiModel
import com.jmancebo.pmpd_playground.ut02.alerts.data.EspecificAlertApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiClient {
    fun getAlerts(): List<AlertApiModel>
    fun getAlert(alertId: String): EspecificAlertApiModel?
}

class MockApiClient() : ApiClient {
    override fun getAlerts(): List<AlertApiModel> {
        return mutableListOf(
            AlertApiModel(
                "1",
                "Título del primer alertmodel",
                "Summary del primer alertmodel",
                "1",
                "04/11/2022"
            )
        )
    }

    override fun getAlert(alertId: String): EspecificAlertApiModel {
        return EspecificAlertApiModel(
            "1",
            "1",
            "Título del primer alertmodel",
            "1",
            "04/11/2022",
            "Summary del primer alertmodel",
            "Body del primer alertmodel",
            "Source del primer alertmodel",
            mutableListOf(),
        )
    }

}

class RetrofitApiClient() : ApiClient {

    private val urlEndPoint: String = "https://plagricola.sitehub.es/api/public/"
    private var apiEndPoint: ApiEndPoint

    init {
        apiEndPoint = buildApiService()
    }

    private fun buildApiService(): ApiEndPoint {
        return buildClient().create(ApiEndPoint::class.java)
    }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun getAlerts(): List<AlertApiModel> {
        val call = apiEndPoint.getAlerts()
        val response = call.execute()
        return if (response.isSuccessful) {
            val alerts = response.body()!!.data
            alerts
        } else {
            mutableListOf()
        }
    }

    override fun getAlert(alertId: String): EspecificAlertApiModel? {
        val call = apiEndPoint.getAlert(alertId)
        val response = call.execute()
        return response.body()?.data
    }

}