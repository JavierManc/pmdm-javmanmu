package com.jmancebo.pmpd_playground.alerts.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatTextView
import com.jmancebo.pmpd_playground.R
import com.jmancebo.pmpd_playground.alerts.data.AlertDataRepository
import com.jmancebo.pmpd_playground.alerts.domain.GetAlertUseCase
import com.jmancebo.pmpd_playground.databinding.ActivityAlertBinding

class AlertActivity : AppCompatActivity() {

    private val alertModel: AlertViewModel = AlertViewModel(GetAlertUseCase(AlertDataRepository()))

    private lateinit var viewBanding: ActivityAlertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpBinding()
        render()
    }

    private fun setUpBinding() {
        val layoutInflater = LayoutInflater.from(this)
        viewBanding = ActivityAlertBinding.inflate(layoutInflater)
        setContentView(viewBanding.root)
    }

    private fun render() {
        val alert = alertModel.getAlerts().first()
        viewBanding.infoTitleText.text = alert.title
        viewBanding.infoDateText.text = alert.datePublished
        viewBanding.infoBodyText.text = alert.body
    }
}