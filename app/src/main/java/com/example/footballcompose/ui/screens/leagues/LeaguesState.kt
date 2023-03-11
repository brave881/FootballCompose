package com.example.footballcompose.ui.screens.leagues

import com.example.footballcompose.data.model.Countries
import com.example.footballcompose.data.model.Leagues

data class LeaguesState(
    val data: Leagues? = null, val error: String? = null, val isLoading: Boolean? = null
)
