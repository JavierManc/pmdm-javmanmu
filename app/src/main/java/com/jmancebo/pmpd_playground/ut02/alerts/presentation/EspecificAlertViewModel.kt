package com.jmancebo.pmpd_playground.ut02.alerts.presentation

import androidx.lifecycle.ViewModel
import com.jmancebo.pmpd_playground.R
import com.jmancebo.pmpd_playground.ut02.alerts.domain.AlertModel
import com.jmancebo.pmpd_playground.ut02.alerts.domain.GetEspecificAlertUseCase


class EspecificAlertViewModel(
    private val getEspecificAlertUseCase: GetEspecificAlertUseCase,
) : ViewModel() {

    // Dejo esta función comentada porque la usaré cuando pueda utilizar coroutine
    /*
    fun render(alertId: String) {

        viewModelScope.launch(Dispatchers.Main) {
            val alert = getEspecificAlertUseCase.execute(alertId)
            if (alert != null) {
                bind.alertTitle.text = alert.title
                bind.alertIcon.setImageResource(selectIcon(alert.type))
                bind.firstFileTitle.text = alert.files[0].name
                bind.especificAlertContent.text = alert.body
            }

        }


    }
    */
    fun getAlert(alertId: String): AlertModel? {
        return getEspecificAlertUseCase.execute(alertId)
    }

    private fun selectIcon(type: Int): Int = when (type) {
        1 -> R.drawable.ic_warning_amber_red_24dp
        else -> R.drawable.ic_info_blue_24dp
    }
}