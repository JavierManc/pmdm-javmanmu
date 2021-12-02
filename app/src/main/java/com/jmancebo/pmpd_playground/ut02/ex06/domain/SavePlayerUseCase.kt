package com.jmancebo.pmpd_playground.ut02.ex06.domain

import com.jmancebo.pmpd_playground.ut02.ex06.data.SharedPrefLocalSource

class SavePlayerUseCase(private val sharedPref: SharedPrefLocalSource) {

    fun execute(param: Param) {
        sharedPref.save(param)
    }

    data class Param(
        val name: String,
        val surname: String,
        val comunity: String,
        val gender: String,
        val firstPosition: String,
        val secondPosition: String?,
        val thirdPosition: String?
    )
}