package com.jmancebo.pmpd_playground.ut02.ex06.data

import android.content.Context
import com.jmancebo.pmpd_playground.ut02.ex06.domain.PlayerModel
import com.jmancebo.pmpd_playground.ut02.ex06.serializer.JsonSerializer

class SharedPrefLocalSource(
    activity: Context,
    private val json: JsonSerializer
) {
    private val sharedpref = activity.getSharedPreferences(
        "player_shared_pref_ls",
        Context.MODE_PRIVATE
    )

    fun save(model: PlayerModel) {
        val edit = sharedpref.edit()
        edit.putString(model.name, json.toJson(model, PlayerModel::class.java))
        edit.apply()
    }

    fun fetchAll(): List<PlayerModel> {
        return sharedpref.all.map { entity ->
            json.fromJson(entity.value.toString(), PlayerModel::class.java)
        }
    }
}