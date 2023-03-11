package com.example.footballcompose.ui.screens.leagues

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.footballcompose.common.Constants
import com.example.footballcompose.data.model.Leagues

data class LeaguesScreen(val countryId: String) : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<ViewModelLeagues>()
        viewModel.getLeagues(countryId = countryId, Constants.API_KEY)
        LeaguesScreenContent(items = viewModel.state.data)
    }


    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun LeaguesScreenContent(
        modifier: Modifier = Modifier, items: Leagues?
    ) {
        LazyColumn {
            item {
                items?.forEach { item ->
                    Column(modifier = modifier.fillMaxSize()) {
                        GlideImage(
                            model = item.league_logo,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "League: " + item.league_name,
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.Red,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                        Text(
                            text = "Country: " + item.league_name,
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.Red,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )


                    }
                }
            }
        }
    }
}