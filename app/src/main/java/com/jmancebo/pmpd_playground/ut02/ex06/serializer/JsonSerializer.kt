package com.jmancebo.pmpd_playground.ut02.ex06.serializer

interface JsonSerializer {
    fun <T> toJson(obj: T, typeClass: Class<T>): String
    fun <T> fromJson(json: String, typeClass: Class<T>): T
}