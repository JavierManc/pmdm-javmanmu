package com.jmancebo.pmpd_playground.alerts.data

import com.jmancebo.pmpd_playground.alerts.domain.AlertModel
import com.jmancebo.pmpd_playground.alerts.domain.AlertRepository

class AlertDataRepository(): AlertRepository {

    override fun getAlerts(): List<AlertModel> {
        return mutableListOf(
            AlertModel(
                "1",
                "Título del primer alertmodel",
                1,
                "Summary del primer alertmodel",
                "04/11/2022",
                "Este es el body del primer alertmodel",
                "Source del primer alertmodel",
                mutableListOf()
            )
        )
    }


}