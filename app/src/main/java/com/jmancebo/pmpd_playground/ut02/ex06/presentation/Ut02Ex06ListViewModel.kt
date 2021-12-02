package com.jmancebo.pmpd_playground.ut02.ex06.presentation

import com.jmancebo.pmpd_playground.ut02.ex06.domain.GetPlayerUseCase
import com.jmancebo.pmpd_playground.ut02.ex06.domain.SavePlayerUseCase

class Ut02Ex06ListViewModel(private val useCase: GetPlayerUseCase) {

    fun getPlayers(): List<SavePlayerUseCase.Param> {
        return useCase.execute()
    }
}