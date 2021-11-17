package com.jmancebo.pmpd_playground.ut02.alerts.data

import com.jmancebo.pmpd_playground.ut02.alerts.domain.AlertModel
import com.jmancebo.pmpd_playground.ut02.alerts.domain.FileModel

data class AlertApiModel(
    val alert_id: String,
    val title: String,
    val summary: String,
    val type: String,
    val date: String
){
    fun toModel(): AlertModel = AlertModel(alert_id, title, type.toInt(),summary,date,summary,"", mutableListOf())
}


data class EspecificAlertApiModel(
    val id: String,
    val alert_id: String,
    val title: String,
    val type: String,
    val date: String,
    val summary: String,
    val body: String,
    val source: String,
    val files: List<FileApiModel>
) {

    fun toModel(): AlertModel = AlertModel(
        alert_id,
        title,
        type.toInt(),
        summary,
        date,
        body,
        source,
        files.map { fileApiModel -> fileApiModel.toModel() }
    )

}

data class FileApiModel(val id: String, val alert_id: String, val name: String, val url: String) {
    fun toModel(): FileModel = FileModel(name, url)
}

