package com.rf.bandmeets.domain

interface RemoteConfig {

    fun getBoolean(key: String?): Boolean

    fun getList(key: String?): List<String?>?

    fun <T> getObject(key: String?, type: Class<T>?): T

    fun getString(key: String?): String?
}