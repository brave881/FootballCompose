package com.example.footballcompose.ui.screens.country

import com.example.footballcompose.data.model.Countries

data class CountryUiState(
    val data: Countries? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

