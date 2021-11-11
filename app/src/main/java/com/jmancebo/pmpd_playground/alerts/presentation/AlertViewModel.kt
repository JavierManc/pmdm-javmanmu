package com.jmancebo.pmpd_playground.alerts.presentation

import androidx.lifecycle.ViewModel
import com.jmancebo.pmpd_playground.alerts.domain.AlertModel
import com.jmancebo.pmpd_playground.alerts.domain.GetAlertUseCase

class AlertViewModel(private val getAlertUseCase: GetAlertUseCase) : ViewModel() {

    fun getAlerts(): List<AlertViewState> {
        val alerts = getAlertUseCase.execute()
        return alerts.map { alertModel ->
            AlertViewState(
                alertModel.title,
                alertModel.datePublished,
                alertModel.body
            )
        }
    }
}