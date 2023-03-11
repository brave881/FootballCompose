package com.example.footballcompose.ui.screens.leagues

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballcompose.common.ResultData
import com.example.footballcompose.presentation.use_cases.LeaguesUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelLeagues @Inject constructor(
    private val leaguesUseCase: LeaguesUseCase
) : ViewModel() {
    var state by mutableStateOf(LeaguesState())
        private set

    fun getLeagues(countryId: String, apiKey: String) {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            leaguesUseCase(countryId, apiKey).onEach { result ->
                when (result) {
                    is ResultData.Success -> {
                        state = state.copy(
                            data = result.data, isLoading = false
                        )
                    }
                    is ResultData.Loading -> {
                        state = state.copy(
                            isLoading = result.isLoading
                        )
                    }
                    is ResultData.Error -> {
                        state = state.copy(
                            error = result.message, isLoading = false
                        )
                    }
                }

            }.collect()
        }


    }

}