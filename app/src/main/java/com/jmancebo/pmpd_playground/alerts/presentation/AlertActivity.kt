package com.jmancebo.pmpd_playground.alerts.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jmancebo.pmpd_playground.alerts.data.AlertDataRepository
import com.jmancebo.pmpd_playground.alerts.data.AlertRemoteSource
import com.jmancebo.pmpd_playground.alerts.app.RetrofitApiClient
import com.jmancebo.pmpd_playground.alerts.domain.GetAlertUseCase
import com.jmancebo.pmpd_playground.databinding.ActivityAlertBinding

class AlertActivity : AppCompatActivity() {

    private val alertModel: AlertViewModel = AlertViewModel(
        GetAlertUseCase(
            AlertDataRepository(
                AlertRemoteSource(RetrofitApiClient())
            )
        )
    )

    private lateinit var viewBanding: ActivityAlertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpBinding()
        render()
    }

    private fun setUpBinding() {
        viewBanding = ActivityAlertBinding.inflate(layoutInflater)
        setContentView(viewBanding.root)
    }

    private fun render() {
        Thread {
            val alert = alertModel.getAlerts().first()
            runOnUiThread {
                viewBanding.infoTitleText.text = alert.title
                viewBanding.infoDateText.text = alert.datePublished
                viewBanding.infoBodyText.text = alert.body
            }
        }.start()
    }
}