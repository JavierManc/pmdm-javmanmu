package com.jmancebo.pmpd_playground.alerts.domain

interface AlertRepository {

    fun getAlerts():List<AlertModel>

}