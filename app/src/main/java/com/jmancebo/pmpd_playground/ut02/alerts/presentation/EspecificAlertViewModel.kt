package com.jmancebo.pmpd_playground.ut02.alerts.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmancebo.pmpd_playground.ut02.alerts.domain.GetEspecificAlertUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EspecificAlertViewModel(
    private val getEspecificAlertUseCase: GetEspecificAlertUseCase
) : ViewModel() {

    val alertViewState: LiveData<AlertViewState>
        get() = _alertViewState

    private val _alertViewState: MutableLiveData<AlertViewState> by lazy {
        MutableLiveData<AlertViewState>()
    }

    fun getAlertDetail(alertId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val alert = getEspecificAlertUseCase.execute(alertId)
            alert?.let {
                _alertViewState.postValue(AlertViewState.fromAlertModel(it))
            }
        }
    }
}