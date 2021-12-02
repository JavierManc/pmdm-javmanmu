package com.jmancebo.pmpd_playground.ut02.alerts.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmancebo.pmpd_playground.ut02.alerts.domain.AlertModel
import com.jmancebo.pmpd_playground.ut02.alerts.domain.GetAlertUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AlertViewModel(private val getAlertUseCase: GetAlertUseCase) : ViewModel() {

    val alertViewState: LiveData<List<AlertViewState>>
        get() = _alertViewState


    private val _alertViewState: MutableLiveData<List<AlertViewState>> by lazy {
        MutableLiveData<List<AlertViewState>>()
    }

    fun getAlerts() {
        viewModelScope.launch(Dispatchers.IO) {
            _alertViewState.postValue(getAlertUseCase.execute().map { AlertViewState.fromAlertModel(it) })
        }
    }
}