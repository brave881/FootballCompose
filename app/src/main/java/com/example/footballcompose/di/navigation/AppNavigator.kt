package com.example.footballcompose.di.navigation

interface AppNavigator {

    suspend fun pop()
    suspend fun navigateTo(appScreen: AppScreen)
    suspend fun navigateTo(appScreen: List<AppScreen>)
    suspend fun replaceAll(screen: AppScreen)
    suspend fun <T : AppScreen> backUntil(clazz: Class<T>)
}