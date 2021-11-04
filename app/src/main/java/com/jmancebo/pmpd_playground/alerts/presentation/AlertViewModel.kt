package com.jmancebo.pmpd_playground.alerts.presentation

import androidx.lifecycle.ViewModel
import com.jmancebo.pmpd_playground.alerts.domain.AlertModel
import com.jmancebo.pmpd_playground.alerts.domain.GetAlertUseCase

class AlertViewModel(private val getAlertUseCase: GetAlertUseCase): ViewModel() {

    fun getAlerts(): List<AlertModel> = getAlertUseCase.execute()
}