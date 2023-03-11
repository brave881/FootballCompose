package com.example.footballcompose.di

import com.example.footballcompose.common.Constants
import com.example.footballcompose.data.remote.AllCountryApi
import com.example.footballcompose.data.repository.CountryRepositoryImpl
import com.example.footballcompose.presentation.repository.CountryRepository
import com.example.footballcompose.presentation.use_cases.CountryListUseCase
import com.example.footballcompose.presentation.use_cases.LeaguesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @[Provides Singleton]
    fun provideAllCountryApi(): AllCountryApi {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL).build().create(AllCountryApi::class.java)
    }

    @[Provides Singleton]
    fun provideRepository(allCountryApi: AllCountryApi): CountryRepository {
        return CountryRepositoryImpl(allCountryApi)
    }

    @[Provides Singleton]
    fun provideCountryListUseCase(repository: CountryRepository): CountryListUseCase {
        return CountryListUseCase(repository)
    }

    @[Provides Singleton]
    fun provideLeaguesUseCase(repository: CountryRepository): LeaguesUseCase {
        return LeaguesUseCase(repository)
    }
}