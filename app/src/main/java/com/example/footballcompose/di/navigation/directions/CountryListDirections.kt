package com.example.footballcompose.di.navigation.directions

import com.example.footballcompose.data.model.Leagues

interface CountryListDirections {

    suspend fun toLeaguesScreen(countryId:String)

}