package com.example.footballcompose.ui.screens.country

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballcompose.common.Constants
import com.example.footballcompose.common.ResultData
import com.example.footballcompose.di.navigation.directions.CountryListDirections
import com.example.footballcompose.presentation.use_cases.CountryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelGetCountryList @Inject constructor(
    private val countryListUseCase: CountryListUseCase,
    private val countryListDirection: CountryListDirections
) : ViewModel() {
    private var _state = mutableStateOf(CountryUiState())
    val state: State<CountryUiState> = _state

    fun onEventDispatcher(intent: CountryIntent) {
        when (intent) {
            is CountryIntent.NavigateToLeaguesScreen -> {
                viewModelScope.launch { countryListDirection.toLeaguesScreen(intent.countryId) }

            }
            is CountryIntent.GetCountries -> {
                viewModelScope.launch {
                    _state.value = _state.value.copy(
                        isLoading = true, error = null
                    )
                    countryListUseCase.invoke(Constants.API_KEY).onEach { action ->
                        when (action) {
                            is ResultData.Success -> {
                                _state.value = _state.value.copy(
                                    data = action.data
                                )
                            }
                            is ResultData.Error -> {
                                _state.value = _state.value.copy(
                                    error = action.message
                                )
                            }
                            is ResultData.Loading -> {
                                _state.value = _state.value.copy(
                                    isLoading = action.isLoading
                                )
                            }
                        }
                    }.collect()
                }
            }
        }

    }


}