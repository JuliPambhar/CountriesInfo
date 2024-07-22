package com.app.countriesinfo.di

import com.app.countriesinfo.ui.connectivityUtils.ConnectivityObserver
import com.app.countriesinfo.ui.connectivityUtils.ConnectivityObserverImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ConnectivityModule {

    @Binds
    internal abstract fun bindsConnectivityObserver(
        connectivityObserver: ConnectivityObserverImpl,
    ): ConnectivityObserver
}