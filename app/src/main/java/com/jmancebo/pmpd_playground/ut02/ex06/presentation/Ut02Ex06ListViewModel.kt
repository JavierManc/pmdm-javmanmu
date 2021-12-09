package com.jmancebo.pmpd_playground.ut02.ex06.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmancebo.pmpd_playground.ut02.ex06.domain.GetPlayerUseCase
import com.jmancebo.pmpd_playground.ut02.ex06.domain.SavePlayerUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ut02Ex06ListViewModel(private val useCase: GetPlayerUseCase) : ViewModel() {

    val playerListViewState: LiveData<List<SavePlayerUseCase.Param>>
        get() = _playerListViewState

    private val _playerListViewState: MutableLiveData<List<SavePlayerUseCase.Param>> by lazy {
        MutableLiveData<List<SavePlayerUseCase.Param>>()
    }


    fun getPlayers() {
        viewModelScope.launch(Dispatchers.IO) {
            _playerListViewState.postValue(useCase.execute())
        }
    }
}