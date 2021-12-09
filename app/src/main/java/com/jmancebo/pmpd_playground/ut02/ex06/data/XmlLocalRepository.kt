package com.jmancebo.pmpd_playground.ut02.ex06.data

import com.jmancebo.pmpd_playground.ut02.ex06.domain.PlayerDataRepository
import com.jmancebo.pmpd_playground.ut02.ex06.domain.PlayerModel

class XmlLocalRepository(private val sharedPrefLocalSource: SharedPrefLocalSource) :
    PlayerDataRepository {

    override fun fetchAll(): List<PlayerModel> {
        return sharedPrefLocalSource.fetchAll()
    }

    override fun save(model: PlayerModel) {
        sharedPrefLocalSource.save(model)
    }

}