package com.jmancebo.pmpd_playground.ut02.alerts.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmancebo.pmpd_playground.databinding.ActivityAlertBinding
import com.jmancebo.pmpd_playground.ut02.alerts.app.RetrofitApiClient
import com.jmancebo.pmpd_playground.ut02.alerts.data.AlertDataRepository
import com.jmancebo.pmpd_playground.ut02.alerts.data.AlertRemoteSource
import com.jmancebo.pmpd_playground.ut02.alerts.domain.GetAlertUseCase

class AlertActivity : AppCompatActivity() {

    private val alertModel: AlertViewModel = AlertViewModel(
        GetAlertUseCase(
            AlertDataRepository(
                AlertRemoteSource(RetrofitApiClient())
            )
        )
    )
    private val alertAdapter = AlertAdapter()

    private val bind: ActivityAlertBinding by lazy {
        ActivityAlertBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        setUpView()
        setUpRecyclerView()
    }

    private fun setUpView() {
        bind.listAlerts.adapter = alertAdapter
        bind.listAlerts.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun setUpRecyclerView() {
        Thread {
            val alerts = alertModel.getAlerts()
            runOnUiThread {
                alertAdapter.setItems(alerts)
            }
        }.start()
    }
}