package com.example.footballcompose.di.navigation.directions.impl

import com.example.footballcompose.di.navigation.AppNavigator
import com.example.footballcompose.di.navigation.directions.CountryListDirections
import com.example.footballcompose.ui.screens.leagues.LeaguesScreen
import javax.inject.Inject

class CountryListDirectionsImpl @Inject constructor(val appNavigator: AppNavigator) :
    CountryListDirections {
    override suspend fun toLeaguesScreen(countryId: String) {
        appNavigator.navigateTo(LeaguesScreen(countryId))
    }
}