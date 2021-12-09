package com.jmancebo.pmpd_playground.ut02.ex06.domain

interface PlayerDataRepository {
    fun fetchAll(): List<PlayerModel>
    fun save(model: PlayerModel)
}