package com.jmancebo.pmpd_playground.alerts.data

import com.jmancebo.pmpd_playground.alerts.domain.AlertModel
import com.jmancebo.pmpd_playground.alerts.domain.AlertRepository

class AlertDataRepository(private val alertRemoteSource: AlertRemoteSource) : AlertRepository {

    override fun getAlerts(): List<AlertModel> {
        val models = alertRemoteSource.getAlerts()
        return models
    }


}