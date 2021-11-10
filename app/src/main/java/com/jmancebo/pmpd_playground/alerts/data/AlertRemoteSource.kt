package com.jmancebo.pmpd_playground.alerts.data

import com.jmancebo.pmpd_playground.alerts.app.ApiClient
import com.jmancebo.pmpd_playground.alerts.domain.AlertModel

class AlertRemoteSource(private var apiClient: ApiClient) {

    fun getAlerts(): List<AlertModel> {
        val alerts = apiClient.getAlerts()
        return alerts.map { alertApiModel -> alertApiModel.toModel() }
    }

}