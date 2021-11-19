package com.jmancebo.pmpd_playground.ut02.alerts.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.jmancebo.pmpd_playground.R
import com.jmancebo.pmpd_playground.databinding.ActivityEspecificAlertBinding
import com.jmancebo.pmpd_playground.ut02.alerts.app.RetrofitApiClient
import com.jmancebo.pmpd_playground.ut02.alerts.data.AlertDataRepository
import com.jmancebo.pmpd_playground.ut02.alerts.data.AlertRemoteSource
import com.jmancebo.pmpd_playground.ut02.alerts.domain.GetEspecificAlertUseCase

class EspecificAlertActivity : AppCompatActivity() {

    private val especificAlertViewModel: EspecificAlertViewModel = EspecificAlertViewModel(
        GetEspecificAlertUseCase(
            AlertDataRepository(
                AlertRemoteSource(RetrofitApiClient())
            )
        )
    )

    private val bind: ActivityEspecificAlertBinding by lazy {
        ActivityEspecificAlertBinding.inflate(layoutInflater)
    }

    companion object {
        private val INTENT_EXTRA_PARAM_ALERT_ID = "key_alert_id"

        fun getIntent(context: Context, alertId: String): Intent {
            val intent = Intent(context, EspecificAlertActivity::class.java)
            intent.putExtra(INTENT_EXTRA_PARAM_ALERT_ID, alertId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpView()
    }

    private fun setUpView() {
        setContentView(bind.root)
        render(getAlertId())
        setupCustomToolbar()
        // Dejo esto comentado porque lo usaré cuando pueda utilizar coroutine
        //especificAlertViewModel.render(getAlertId())
    }

    private fun setupCustomToolbar() {
        setSupportActionBar(bind.alertListCustomToolbar.toolbar)
        supportActionBar?.title = "Alerta"
    }

    private fun getAlertId(): String {
        return intent.extras!!.getString(INTENT_EXTRA_PARAM_ALERT_ID, "0")
    }

    private fun render(alertId: String) {
        Thread {
            val alert = especificAlertViewModel.getAlert(alertId)
            runOnUiThread {
                if (alert != null) {
                    bind.alertTitle.text = alert.title
                    bind.alertIcon.setImageResource(selectIcon(alert.type))
                    bind.firstFileTitle.text = alert.files[0].name
                    bind.especificAlertContent.text =
                        HtmlCompat.fromHtml(alert.body, HtmlCompat.FROM_HTML_MODE_LEGACY);
                }
            }
        }.start()
    }

    private fun selectIcon(type: Int): Int = when (type) {
        1 -> R.drawable.ic_warning_amber_red_24dp
        else -> R.drawable.ic_info_blue_24dp
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