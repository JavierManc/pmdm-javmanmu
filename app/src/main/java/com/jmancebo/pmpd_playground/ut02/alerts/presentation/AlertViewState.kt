package com.jmancebo.pmpd_playground.ut02.alerts.presentation

import com.jmancebo.pmpd_playground.ut02.alerts.domain.AlertModel
import com.jmancebo.pmpd_playground.ut02.alerts.domain.FileModel

data class AlertViewState(
    val id: String,
    val title: String,
    val type: Int,
    val date: String,
    val body: String,
    val files: List<FileModel>
) {
    companion object{
        fun fromAlertModel(alert: AlertModel) = AlertViewState(
            alert.id,
            alert.title,
            alert.type,
            alert.datePublished,
            alert.body,
            alert.files
        )
    }
}