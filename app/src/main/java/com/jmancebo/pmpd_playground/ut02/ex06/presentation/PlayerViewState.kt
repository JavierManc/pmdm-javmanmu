package com.jmancebo.pmpd_playground.ut02.ex06.presentation

import com.jmancebo.pmpd_playground.ut02.ex06.domain.PlayerModel

data class PlayerViewState(
    val name: String,
    val surname: String,
    val comunity: String,
    val gender: String,
    val firstPosition: String,
    val secondPosition: String?,
    val thirdPosition: String?
) {
    fun toModel(): PlayerModel {
        val positions: MutableList<String> = mutableListOf()
        positions.add(firstPosition)
        if (secondPosition != null) {
            positions.add(secondPosition)
            if (thirdPosition != null) {
                positions.add(thirdPosition)
            }
        }
        return PlayerModel(
            this.name,
            this.surname,
            this.comunity,
            this.gender,
            positions
        )
    }

    companion object {
        fun modelToViewState(player: PlayerModel): PlayerViewState =
            PlayerViewState(
                player.name,
                player.surname,
                player.comunity,
                player.gender,
                player.position[0],
                player.position[1],
                player.position[2]
            )
    }
}