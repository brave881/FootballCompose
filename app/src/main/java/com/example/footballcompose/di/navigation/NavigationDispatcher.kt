package com.example.footballcompose.di.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

class NavigationDispatcher @Inject constructor() :
    AppNavigator, AppNavigatorHandler {
    override val navigation = MutableSharedFlow<NavigatorArgs>()
    override suspend fun pop() {
        navigator {
            pop()
        }
    }

    override suspend fun navigateTo(appScreen: AppScreen) = navigator {
        push(appScreen)
    }

    override suspend fun navigateTo(appScreen: List<AppScreen>) = navigator {
        push(appScreen)
    }

    override suspend fun replaceAll(screen: AppScreen) = navigator {
        replaceAll(screen)
    }

    override suspend fun <T : AppScreen> backUntil(clazz: Class<T>) = navigator {
        popUntil { it::class == clazz }
    }

    private suspend fun navigator(navigatorArgs: NavigatorArgs) {
        navigation.emit(navigatorArgs)
    }

}