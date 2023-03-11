package com.example.footballcompose.data.model

import com.google.gson.annotations.SerializedName

data class CountriesItem(
    @SerializedName("country_id") val countryId: String,
    @SerializedName("country_logo") val countryLogo: String,
    @SerializedName("country_name") val countryName: String
)