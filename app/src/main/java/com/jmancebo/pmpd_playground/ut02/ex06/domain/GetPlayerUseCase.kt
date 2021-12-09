package com.jmancebo.pmpd_playground.ut02.ex06.domain

class GetPlayerUseCase(private val playerDataRepository: PlayerDataRepository) {

    fun execute(): List<PlayerModel> {
        return playerDataRepository.fetchAll()
    }
}