package com.example.footballcompose.presentation.use_cases

import com.example.footballcompose.common.ResultData
import com.example.footballcompose.presentation.repository.CountryRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CountryListUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    operator fun invoke(apiKey: String) = flow {
        try {
            emit(ResultData.Loading(true))
            val data = repository.getCountries(apiKey)
            emit(ResultData.Success(data = data))
        } catch (e: java.lang.Exception) {
            emit(ResultData.Error(e.message.toString()))
        }

    }
}