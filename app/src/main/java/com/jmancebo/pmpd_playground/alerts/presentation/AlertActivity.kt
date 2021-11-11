package com.jmancebo.pmpd_playground.alerts.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
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

    private fun setUpRecyclerView(){
        Thread {
            alertAdapter.setItems(alertModel.getAlerts())
        }.start()
    }
}