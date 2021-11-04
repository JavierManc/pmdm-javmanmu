package com.jmancebo.pmpd_playground.alerts.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatTextView
import com.jmancebo.pmpd_playground.R
import com.jmancebo.pmpd_playground.alerts.data.AlertDataRepository
import com.jmancebo.pmpd_playground.alerts.domain.AlertModel
import com.jmancebo.pmpd_playground.alerts.domain.AlertRepository
import com.jmancebo.pmpd_playground.alerts.domain.GetAlertUseCase

class AlertActivity : AppCompatActivity() {

    private val alertModel: AlertViewModel = AlertViewModel(GetAlertUseCase(AlertDataRepository()))


    lateinit var infoTitleText: AppCompatTextView
    lateinit var infoDateText: AppCompatTextView
    lateinit var infoBodyText: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)
        setUpView()
        render()
    }

    private fun setUpView() {
        infoTitleText = findViewById(R.id.info_title_text)
        infoDateText = findViewById(R.id.info_date_text)
        infoBodyText = findViewById(R.id.info_body_text)
    }

    private fun render() {
        val alert = alertModel.getAlert().first()
        infoTitleText.text = alert.title
        infoDateText.text = alert.datePublished
        infoBodyText.text = alert.body
    }
}