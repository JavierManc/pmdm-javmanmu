package com.jmancebo.pmpd_playground.ut02.alerts.data

import com.jmancebo.pmpd_playground.ut02.alerts.domain.AlertModel
import com.jmancebo.pmpd_playground.ut02.alerts.domain.AlertRepository

class AlertDataRepository(private val alertRemoteSource: AlertRemoteSource) : AlertRepository {

    override fun getAlerts(): List<AlertModel> {
        return alertRemoteSource.getAlerts()
    }

    override fun getAlert(alertId: String): AlertModel? {
        return alertRemoteSource.getAlert(alertId)
    }
}