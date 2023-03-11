package com.example.footballcompose.ui.screens.country

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.footballcompose.data.model.CountriesItem
import com.example.footballcompose.di.navigation.AppScreen

const val TAG = "TTT"

class CountryList : AppScreen() {
    @Composable
    override fun Content() {
        val viewModel: ViewModelGetCountryList = getViewModel()
        val state = viewModel.state
        CountryListContent(state = state, viewModel::onEventDispatcher)
    }

    @Composable
    fun CountryListContent(
        state: State<CountryUiState>, onEventDispatcher: (CountryIntent) -> Unit
    ) {
        LazyColumn {
            state.value.data?.forEach { itemCountry ->
                item {
                    CountryItem(
                        countriesItem = itemCountry, onEventDispatcher = onEventDispatcher
                    )
                }
            }
        }
    }


    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    private fun CountryItem(
        modifier: Modifier = Modifier,
        countriesItem: CountriesItem,
        onEventDispatcher: (CountryIntent) -> Unit
    ) {
        Row(
            modifier = modifier.clickable {
                onEventDispatcher(CountryIntent.NavigateToLeaguesScreen(countriesItem.countryId))
            },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(
                model = countriesItem.countryLogo,
                contentDescription = null,
                modifier = Modifier
                    .height(56.dp)
                    .width(56.dp)
                    .padding(16.dp)
            )
            Text(
                text = countriesItem.countryName,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineMedium
            )


        }
    }


//    @OptIn(ExperimentalGlideComposeApi::class)
//    @Composable
//    private fun CountryItem(
//        modifier: Modifier = Modifier, countriesItem: CountriesItem, content: () -> Unit
//    ) {
//        Row(
//            modifier = modifier
//                .fillMaxWidth()
//                .clickable {
//                    content.invoke()
//                },
//            horizontalArrangement = Arrangement.Start,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Log.d(TAG, "CountryItem: ${countriesItem.countryName}")
//            GlideImage(
//                model = countriesItem.countryLogo,
//                contentDescription = null,
//                modifier = Modifier
//                    .height(56.dp)
//                    .width(56.dp)
//                    .padding(16.dp)
//            )
//            Text(
//                text = countriesItem.countryName,
//                modifier = Modifier.padding(16.dp),
//                style = MaterialTheme.typography.headlineMedium
//            )
//        }
//    }
}