package com.example.footballcompose.presentation.use_cases

import com.example.footballcompose.common.ResultData
import com.example.footballcompose.presentation.repository.CountryRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LeaguesUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    operator fun invoke(countryId: String, apiKey: String) = flow {
        try {
            emit(ResultData.Loading(true))
            val data = repository.getLeagues(countryId, apiKey)
            emit(ResultData.Success(data))
        } catch (e: java.lang.Exception) {
            emit(ResultData.Error(e.message.toString()))
        }
    }
}