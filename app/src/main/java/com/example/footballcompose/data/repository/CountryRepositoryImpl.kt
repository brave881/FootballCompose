package com.example.footballcompose.data.repository

import com.example.footballcompose.data.model.Countries
import com.example.footballcompose.data.model.Leagues
import com.example.footballcompose.data.remote.AllCountryApi
import com.example.footballcompose.presentation.repository.CountryRepository
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val api: AllCountryApi
) : CountryRepository {
    override suspend fun getCountries(apiKey: String): Countries {
        return api.getAllCountry(apiKey)
    }

    override suspend fun getLeagues(countryId: String, apiKey: String): Leagues {
        return api.getLeagues(countryId = countryId, apiKey = apiKey)
    }

}