package com.app.countriesinfo.ui.connectivityUtils

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {

    fun observe(): Flow<Status>

    enum class Status {
        Unknown, Available, Unavailable, Losing, Lost
    }
}