package com.jmancebo.pmpd_playground.ut02.ex06.domain

class SavePlayerUseCase(private val playerDataRepository: PlayerDataRepository) {

    fun execute(model: PlayerModel) {
        playerDataRepository.save(model)
    }
}