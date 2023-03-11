package com.example.footballcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.example.footballcompose.di.navigation.AppNavigatorHandler
import com.example.footballcompose.ui.screens.country.CountryList
import com.example.footballcompose.ui.theme.FootballComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigatorHandler: AppNavigatorHandler

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FootballComposeTheme {
                Navigator(screen = CountryList()) { navigator ->
                    LaunchedEffect(key1 = navigator) {
                        navigatorHandler.navigation.onEach {
                            it(navigator)
                        }.collect()
                    }
                    SlideTransition(navigator = navigator)
                    CurrentScreen()
                }

            }
        }
    }
}
