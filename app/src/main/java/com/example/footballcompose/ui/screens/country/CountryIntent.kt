package com.example.footballcompose.ui.screens.country

sealed interface CountryIntent {
    data class NavigateToLeaguesScreen(val countryId: String) : CountryIntent
    object GetCountries : CountryIntent

}