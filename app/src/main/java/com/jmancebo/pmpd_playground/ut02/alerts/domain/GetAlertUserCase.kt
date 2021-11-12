package com.jmancebo.pmpd_playground.ut02.alerts.domain

class GetAlertUseCase(val alertRepository: AlertRepository){

    fun execute(): List<AlertModel> {
        return alertRepository.getAlerts()
    }
}