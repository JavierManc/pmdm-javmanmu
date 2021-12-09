package com.jmancebo.pmpd_playground.ut02.ex06.presentation

import androidx.lifecycle.ViewModel
import com.jmancebo.pmpd_playground.ut02.ex06.domain.PlayerModel
import com.jmancebo.pmpd_playground.ut02.ex06.domain.SavePlayerUseCase

class Ut02Ex06FormViewModel(val useCase: SavePlayerUseCase) : ViewModel() {

    fun savePlayer(player: PlayerViewState) {
        useCase.execute(player.toModel())
    }
}