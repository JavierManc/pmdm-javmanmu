package com.jmancebo.pmpd_playground.alerts.domain

class GetAlertUseCase(val alertRepository: AlertRepository){

    fun execute(): List<AlertModel> {
        return alertRepository.getAlerts()
    }
}