package com.jmancebo.pmpd_playground.alerts.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jmancebo.pmpd_playground.databinding.AlertInfoItemBinding

class AlertViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val bind = AlertInfoItemBinding.bind(view)

    fun render(alertViewState: AlertViewState){
        bind.infoTitleText.text = alertViewState.title
        bind.infoDateText.text = alertViewState.date
        bind.infoBodyText.text = alertViewState.body
    }
}