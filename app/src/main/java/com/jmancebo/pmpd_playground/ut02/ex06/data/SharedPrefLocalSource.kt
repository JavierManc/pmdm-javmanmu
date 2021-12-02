package com.jmancebo.pmpd_playground.ut02.ex06.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.jmancebo.pmpd_playground.ut02.ex06.domain.SavePlayerUseCase
import com.jmancebo.pmpd_playground.ut02.ex06.serializer.JsonSerializer

class SharedPrefLocalSource(
    activity: Context,
    private val json: JsonSerializer
) {
    private val sharedpref = activity.getSharedPreferences(
        "player_shared_pref_ls",
        Context.MODE_PRIVATE
    )

    fun save(model: SavePlayerUseCase.Param) {
        val edit = sharedpref.edit()
        edit.putString(model.name, json.toJson(model, SavePlayerUseCase.Param::class.java))
        edit.apply()
    }

    fun fetchAll(): List<SavePlayerUseCase.Param> {
        return sharedpref.all.map { entity ->
            json.fromJson(entity.value.toString(), SavePlayerUseCase.Param::class.java)
        }
    }
}