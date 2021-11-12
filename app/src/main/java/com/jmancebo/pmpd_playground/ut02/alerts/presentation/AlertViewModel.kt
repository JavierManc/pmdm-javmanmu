package com.jmancebo.pmpd_playground.ut02.alerts.presentation

import androidx.lifecycle.ViewModel
import com.jmancebo.pmpd_playground.ut02.alerts.domain.GetAlertUseCase

class AlertViewModel(private val getAlertUseCase: GetAlertUseCase) : ViewModel() {

    fun getAlerts(): List<AlertViewState> {
        val alerts = getAlertUseCase.execute()
        return alerts.map { alertModel ->
            AlertViewState(
                alertModel.id,
                alertModel.title,
                alertModel.type,
                alertModel.datePublished,
                alertModel.body
            )
        }
    }
}