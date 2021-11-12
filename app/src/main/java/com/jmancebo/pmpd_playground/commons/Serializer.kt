package com.jmancebo.pmpd_playground.commons

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jmancebo.pmpd_playground.ut02.alerts.domain.AlertModel
import java.lang.reflect.Type

interface Serializer<T> {
    fun toJson(model: T): String
    fun fromJson(json: String): T
}

/**
 * Guía de usuario: https://github.com/google/gson/blob/master/UserGuide.md
 * IMPORTANTE!!!!!! TypeToken de TapaLocalModel metido directamente para la realización del ejercicio.
 * Esto debería estar planteado de otra forma. Lo veremos en próximas unidades.
 */
class GsonSerializer<T> : Serializer<T> {

    private val gson = Gson()
    private val types: Type = TypeToken.getParameterized(AlertModel::class.java).type

    override fun toJson(model: T): String =
        gson.toJson(model, types)

    override fun fromJson(json: String): T {
        return gson.fromJson(json, types)
    }
}