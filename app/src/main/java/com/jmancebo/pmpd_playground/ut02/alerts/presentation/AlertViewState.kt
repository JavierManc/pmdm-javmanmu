package com.jmancebo.pmpd_playground.ut02.alerts.presentation

data class AlertViewState(
    val id: String,
    val title: String,
    val type: Int,
    val date: String,
    val body: String
)