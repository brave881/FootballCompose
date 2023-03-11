package com.example.footballcompose.data.remote

import com.example.footballcompose.data.model.Countries
import com.example.footballcompose.data.model.Leagues
import retrofit2.http.GET
import retrofit2.http.Query

interface AllCountryApi {

    @GET("?action=get_countries")
    suspend fun getAllCountry(
        @Query("APIkey") apiKey: String
    ): Countries


    @GET("?action=get_leagues")
    suspend fun getLeagues(
        @Query("country_id") countryId: String,
        @Query("APIkey") apiKey: String
    ): Leagues


}