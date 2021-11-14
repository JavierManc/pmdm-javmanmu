package com.jmancebo.pmpd_playground.ut02.alerts.data

import com.jmancebo.pmpd_playground.ut02.alerts.app.ApiClient
import com.jmancebo.pmpd_playground.ut02.alerts.domain.AlertModel

class AlertRemoteSource(private var apiClient: ApiClient) {

    fun getAlerts(): List<AlertModel> {
        val alerts = apiClient.getAlerts()
        return alerts.map { alertApiModel -> alertApiModel.toModel() }
    }

}