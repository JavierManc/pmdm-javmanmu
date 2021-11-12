package com.jmancebo.pmpd_playground.ut02.alerts.domain

interface AlertRepository {

    fun getAlerts():List<AlertModel>

}