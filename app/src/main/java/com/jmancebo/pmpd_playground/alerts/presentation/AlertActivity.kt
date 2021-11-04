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
import com.jmancebo.pmpd_playground.databinding.ActivityAlertBinding

class AlertActivity : AppCompatActivity() {

    private val alertModel: AlertViewModel = AlertViewModel(GetAlertUseCase(AlertDataRepository()))

    private lateinit var viewBanding: ActivityAlertBinding

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
        val alert = alertModel.getAlerts().first()
        viewBanding.infoTitleText.text = alert.title
        viewBanding.infoDateText.text = alert.datePublished
        viewBanding.infoBodyText.text = alert.body
    }
}