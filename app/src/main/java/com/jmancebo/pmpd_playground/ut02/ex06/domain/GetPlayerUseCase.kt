package com.jmancebo.pmpd_playground.ut02.ex06.domain

import com.jmancebo.pmpd_playground.ut02.ex06.data.SharedPrefLocalSource

class GetPlayerUseCase(private val sharedPref: SharedPrefLocalSource) {

    fun execute(): List<SavePlayerUseCase.Param> {
        return sharedPref.fetchAll()
    }
}