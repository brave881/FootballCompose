package com.example.footballcompose.di

import com.example.footballcompose.di.navigation.AppNavigator
import com.example.footballcompose.di.navigation.AppNavigatorHandler
import com.example.footballcompose.di.navigation.NavigationDispatcher
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun bindNavigator(appNavigationDispatcher: NavigationDispatcher): AppNavigator

    @Binds
    fun bindNavigationHandler(appNavigationDispatcher: NavigationDispatcher): AppNavigatorHandler
}