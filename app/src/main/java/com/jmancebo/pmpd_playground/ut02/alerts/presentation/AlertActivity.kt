package com.jmancebo.pmpd_playground.ut02.alerts.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmancebo.pmpd_playground.R
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
        setUpView()
        loadAlerts()
    }

    private fun setUpView() {
        setContentView(bind.root)
        setupCustomToolbar()
        setupAlertRecycler()
    }

    private fun setupCustomToolbar() {
        setSupportActionBar(bind.alertListCustomToolbar.toolbar)
        supportActionBar?.title = "Listado de alertas"
    }

    private fun setupAlertRecycler() {
        bind.listAlerts.adapter = alertAdapter
        bind.listAlerts.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun loadAlerts() {
        Thread {
            val alerts = alertModel.getAlerts()
            runOnUiThread {
                alertAdapter.setItems(alerts)
            }
        }.start()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    /**
     * Más info:
     * https://developer.android.com/guide/topics/ui/menus.html
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_add -> {
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings -> {
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_share -> {
                val sharingIntent = Intent(Intent.ACTION_SEND)

                sharingIntent.type = "text/plain"

                val shareBody = "Pulsado botón Share"

                val shareSubject = "En la app de alertas"

                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)

                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
                startActivity(Intent.createChooser(sharingIntent, "Share using"))
                true
            }
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

