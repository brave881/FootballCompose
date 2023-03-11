package com.example.footballcompose.presentation.repository

import com.example.footballcompose.data.model.Countries
import com.example.footballcompose.data.model.Leagues

interface CountryRepository {

    suspend fun getCountries(apiKey: String): Countries
    suspend fun getLeagues(countryId: String, apiKey: String):Leagues

}