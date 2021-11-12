package com.jmancebo.pmpd_playground.ut02.alerts.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jmancebo.pmpd_playground.R
import com.jmancebo.pmpd_playground.databinding.AlertInfoItemBinding

class AlertViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val bind = AlertInfoItemBinding.bind(view)

    fun render(alertViewState: AlertViewState) {
        bind.infoTitleText.text = alertViewState.title
        bind.infoDateText.text = alertViewState.date
        bind.infoBodyText.text = alertViewState.body
        bind.infoIcon.setImageResource(selectIcon2(alertViewState.type))
    }

    private fun selectIcon(type: Int): Int = if (type == 1) {
        R.drawable.ic_warning_amber_red_24dp
    } else {
        R.drawable.ic_info_blue_24dp
    }

    /**
     * Uso de When como alternativa al IF .. ELSE
     * Alternativa IF .. ELSE
     */
    private fun selectIcon2(type: Int): Int = when (type) {
        1 -> R.drawable.ic_warning_amber_red_24dp
        else -> R.drawable.ic_info_blue_24dp
    }
}