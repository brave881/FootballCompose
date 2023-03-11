package com.example.footballcompose.di

import com.example.footballcompose.di.navigation.directions.CountryListDirections
import com.example.footballcompose.di.navigation.directions.impl.CountryListDirectionsImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface DirectionModule {
    @Binds
    fun bindCountryListDirections(impl: CountryListDirectionsImpl): CountryListDirections
}
